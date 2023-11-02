package com.it.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.it.health.domain.MedicalHistoryPatientAssessment;
import com.it.health.repository.MedicalHistoryPatientAssessmentRepository;

@Service
public class PatientRecommendationsService {

	@Autowired
	private MedicalHistoryPatientAssessmentRepository medicalHistoryPatientAssessmentRepository;

	public String get(String patientEmail) {
		String response = "Not Found";
		List<MedicalHistoryPatientAssessment> list = medicalHistoryPatientAssessmentRepository.getByPatientEmail(patientEmail);
		if(!CollectionUtils.isEmpty(list)) {
			MedicalHistoryPatientAssessment mh = list.get(0);
			response = mh.getRecommendations();
		}
		return response;
	}
	
}
