package com.it.health.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.health.domain.MedicalHistoryPatientAssessment;
import com.it.health.dto.CareGiverDto;
import com.it.health.repository.MedicalHistoryPatientAssessmentRepository;

@Service
public class CareGiverService {

	@Autowired
	private MedicalHistoryPatientAssessmentRepository medicalHistoryPatientAssessmentRepository;

	public List<CareGiverDto> get(String patientEmail) {
		List<CareGiverDto> dtos = new ArrayList<>();
		List<MedicalHistoryPatientAssessment> list = medicalHistoryPatientAssessmentRepository
				.getByPatientEmail(patientEmail);
		for (MedicalHistoryPatientAssessment mhpa : list) {
			CareGiverDto dto = new CareGiverDto();
			dto.setAssessment(mhpa.getAssessment());
			dto.setPatientEmail(mhpa.getPatientEmail());
			dto.setRecommendations(mhpa.getRecommendations());
			dto.setStage(mhpa.getStage());
			dto.setDate(mhpa.getCreateDate());
			dtos.add(dto);
		}
		return dtos;
	}

}
