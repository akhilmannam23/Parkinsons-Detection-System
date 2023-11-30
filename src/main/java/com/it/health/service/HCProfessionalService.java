package com.it.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.it.health.domain.MedicalHistoryPatientAssessment;
import com.it.health.dto.PatientInfoDto;
import com.it.health.repository.MedicalHistoryPatientAssessmentRepository;

@Service
public class HCProfessionalService {

	@Autowired
	private MedicalHistoryPatientAssessmentRepository medicalHistoryPatientAssessmentRepository;

	public PatientInfoDto getPatientInfo(String patientEmail) {
		PatientInfoDto dto = new PatientInfoDto();
		List<MedicalHistoryPatientAssessment> list = medicalHistoryPatientAssessmentRepository
				.getByPatientEmail(patientEmail);
		if (CollectionUtils.isEmpty(list)) {
			dto.setError(true);
			dto.setErrorMessage("Patient not found");
		} else {
			MedicalHistoryPatientAssessment mhpa = list.get(0);
			dto.setAssessment(mhpa.getAssessment());
			dto.setPatientEmail(mhpa.getPatientEmail());
			dto.setRecommendations(mhpa.getRecommendations());
			dto.setStage(mhpa.getStage());
			dto.setDate(mhpa.getCreateDate());
		}
		return dto;
	}

}
