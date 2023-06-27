package com.javaspringlabo.monproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaspringlabo.monproject.exception.NoDataFoundException;
import com.javaspringlabo.monproject.model.Marque;
import com.javaspringlabo.monproject.repository.MarqueRepository;
import com.javaspringlabo.monproject.service.IMarqueService;

@Component
public class MarqueServiceImpl implements IMarqueService {

	@Autowired
	private MarqueRepository marqueRepo;

	public List<Marque> findAll() {
		List<Marque> list = marqueRepo.findAll();
		if (list.isEmpty()) {
			throw new NoDataFoundException();
		}
		return list;
	}

	public Marque getById(Integer id) {
		return marqueRepo.findById(id).orElseThrow(NoDataFoundException::new);
	}
}
