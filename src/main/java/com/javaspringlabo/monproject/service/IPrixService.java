package com.javaspringlabo.monproject.service;

import java.util.Date;
import java.util.List;

import com.javaspringlabo.monproject.model.Prix;

public interface IPrixService {

	public Prix getById(Integer id);

	public List<Prix> findAll();

	public List<Prix> findPrixByMarqueId(Integer brandId);

	public Prix findPrixByMarqueIdAndDate(Integer marqueId, Date date);

}
