package com.javaspringlabo.monproject.dto;

import java.io.Serializable;
import java.util.Date;

public class PrixDTO implements Serializable {
	private Integer id = null;
	private String description;
	private Integer marqueId;
	private Date startDate;
	private Date stopDate;
	private Integer priority;
	private Double lePrix;
	private String devise;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMarqueId() {
		return marqueId;
	}

	public void setMarqueId(Integer marqueId) {
		this.marqueId = marqueId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStopDate() {
		return stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Double getLePrix() {
		return lePrix;
	}

	public void setLePrix(Double lePrix) {
		this.lePrix = lePrix;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

}
