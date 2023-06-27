package com.javaspringlabo.monproject.service.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaspringlabo.monproject.exception.NoDataFoundException;
import com.javaspringlabo.monproject.model.Prix;
import com.javaspringlabo.monproject.repository.PrixRepository;
import com.javaspringlabo.monproject.service.IPrixService;

@Component
public class PrixServiceImpl implements IPrixService {

	@Autowired
	private PrixRepository prixRepo;

	public Prix getById(Integer id) {
		return prixRepo.findById(id).orElseThrow(NoDataFoundException::new);
	}

	public List<Prix> findAll() {
		List<Prix> list = prixRepo.findAll();
		if (list.isEmpty()) {
			throw new NoDataFoundException();
		}
		return list;
	}

	public List<Prix> findPrixByMarqueId(Integer marqueId) {
		List<Prix> list = prixRepo.findPrixByMarqueId(marqueId);
		if (list.isEmpty()) {
			throw new NoDataFoundException();
		}
		return list;
	}

	public Prix findPrixByMarqueIdAndDate(Integer marqueId, Date date) {
		List<Prix> list = prixRepo.findPrixByMarqueId(marqueId);
		if (list.isEmpty()) {
			throw new NoDataFoundException();
		}

		return list.stream().filter(thePrix -> thePrix.getStartDate().before(date))
				.filter(thePrix -> (thePrix.getStopDate() == null) || thePrix.getStopDate().after(date))
				.max(Comparator.comparing(Prix::getPriority)).orElseThrow(NoDataFoundException::new);
	}
}
