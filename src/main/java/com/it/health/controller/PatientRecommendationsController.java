package com.it.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.health.service.PatientRecommendationsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/patient-recommendations")
@RestController
@Tag(name = "Controller - As a Patient, I want to receive personalized recommendations for lifestyle changes and"
		+ " preventive measures based on my risk assessement to reduce the chances of developing Pakinson's disease.")
public class PatientRecommendationsController {

	@Autowired
	private PatientRecommendationsService patientRecommendationsService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@Operation(summary = "Get Patient Recommendations")
	public String get(@RequestParam("patient-email") String patientEmail) {
		return patientRecommendationsService.get(patientEmail);
	}

}
