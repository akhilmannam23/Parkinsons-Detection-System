package com.it.health.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.health.domain.MedicalHistoryPatientAssessment;
import com.it.health.dto.ResearcherPatientInfoDto;
import com.it.health.repository.ResearcherRepository;

@Service
public class ResearcherService {

	@Autowired
	private ResearcherRepository researcherRepository;

	public List<ResearcherPatientInfoDto> getAll() {
		List<ResearcherPatientInfoDto> dtos = new ArrayList<>();

		// Getting all patients info in descending order
		List<MedicalHistoryPatientAssessment> list = researcherRepository.getAll();

		long count = 1;
		Set<String> uniqueEmails = new HashSet<>();

		for (MedicalHistoryPatientAssessment mhpa : list) {
			if (uniqueEmails.contains(mhpa.getPatientEmail())) {
				continue;
			}
			ResearcherPatientInfoDto dto = new ResearcherPatientInfoDto();
			dto.setAssessment(mhpa.getAssessment());
			dto.setPatientEmail("Patient " + count);
			dto.setRecommendations(mhpa.getRecommendations());
			dto.setStage(mhpa.getStage());
			dto.setDate(mhpa.getCreateDate());
			dtos.add(dto);

			uniqueEmails.add(mhpa.getPatientEmail());
			count++;
		}
		return dtos;
	}

}
