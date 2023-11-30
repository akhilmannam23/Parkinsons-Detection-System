package com.it.health.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "POC_MEDICAL_HISTORY_PATIENT_INFO")
@SequenceGenerator(name = "POC_HEALTH_PORTAL_SERVICE_SEQ", sequenceName = "POC_HEALTH_PORTAL_SERVICE_SEQ", allocationSize = 1, initialValue = 1)
public class MedicalHistoryPatientInfo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POC_HEALTH_PORTAL_SERVICE_SEQ")
	private Long id;

	@Column(name = "patient_email")
	private String patientEmail;

	@Column(name = "MEDICAL_HISTORY_question_id")
	private Long questionId;

	@Column(name = "MEDICAL_HISTORY_option_id")
	private Long optionId;

	@Column(name = "create_date")
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
