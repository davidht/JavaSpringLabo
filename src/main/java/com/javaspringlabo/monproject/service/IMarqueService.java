package com.javaspringlabo.monproject.service;

import java.util.List;

import com.javaspringlabo.monproject.model.Marque;

public interface IMarqueService {

	public List<Marque> findAll();

	public Marque getById(Integer id);
}
