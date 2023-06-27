package com.javaspringlabo.monproject.dto;

import java.io.Serializable;

public class MarqueDTO implements Serializable {
	private Integer id = null;

	private String nom = "";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
