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
@Table(name = "POC_MEDICAL_HISTORY_PATIENT_ASSESSMENT")
@SequenceGenerator(name = "POC_HEALTH_PORTAL_SERVICE_SEQ", sequenceName = "POC_HEALTH_PORTAL_SERVICE_SEQ", allocationSize = 1, initialValue = 1)
public class MedicalHistoryPatientAssessment {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POC_HEALTH_PORTAL_SERVICE_SEQ")
	private Long id;

	@Column(name = "patient_email")
	private String patientEmail;

	@Column(name = "stage")
	private String stage;

	@Column(name = "assessment")
	private String assessment;
	
	@Column(name = "recommendations")
	private String recommendations;

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

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getAssessment() {
		return assessment;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

}
