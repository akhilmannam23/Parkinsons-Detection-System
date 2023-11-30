package com.it.health.dto;

import java.util.HashMap;
import java.util.Map;

public class MedicalHistoryRequest {

	private Map<Long, Long> questionOptionMap = new HashMap<>();
	private String patientEmail;
	public Map<Long, Long> getQuestionOptionMap() {
		return questionOptionMap;
	}
	public void setQuestionOptionMap(Map<Long, Long> questionOptionMap) {
		this.questionOptionMap = questionOptionMap;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

}
