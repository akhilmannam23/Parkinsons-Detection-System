package com.it.health.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POC_MEDICAL_HISTORY_OPTIONS")
public class MedicalHistoryOptionsEntity {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "options")
	private String options;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

}
