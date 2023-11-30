package com.it.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.health.dto.PatientInfoDto;
import com.it.health.service.HCProfessionalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/health-care-professional")
@RestController
@Tag(name = "Controller - As a Healthcare professional, I want to use application to input patient data and receive"
		+ " predictive insights on the likelihood of Parkinson's disease, aiding in early diagnosis and treatment")
public class HCProfessionalController {

	@Autowired
	private HCProfessionalService hcProfessionalService;

	@RequestMapping(value = "/get-patient-info", method = RequestMethod.GET)
	@Operation(summary = "Get Patient details")
	public PatientInfoDto getPatientInfo(@RequestParam("patient-email") String patientEmail) {
		return hcProfessionalService.getPatientInfo(patientEmail);
	}

}
