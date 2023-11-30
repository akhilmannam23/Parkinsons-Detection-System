package com.it.health.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.health.dto.MedicalHistoryRequest;
import com.it.health.dto.MedicalHistoryResponse;
import com.it.health.service.MedicalHistoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/medical-history")
@RestController
@Tag(name = "Controller - As a Patient, I want to input my medical history and symptoms into the application "
		+ "so that I can receive an initial assessment of my risk for Parkinson'd disease.")
public class MedicalHistoryController {

	@Autowired
	private MedicalHistoryService medicalHistoryService;

	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	@Operation(summary = "Get all Medical History Questions")
	public Map<Long, String> getMedicalHistoryQuestions() {
		return medicalHistoryService.getMedicalHistoryQuestions();
	}

	@RequestMapping(value = "/options", method = RequestMethod.GET)
	@Operation(summary = "Get all Medical History Options")
	public Map<Long, String> getMedicalHistoryOptions() {
		return medicalHistoryService.getMedicalHistoryOptions();
	}

	@RequestMapping(value = "/initial-assessment", method = RequestMethod.POST)
	@Operation(summary = "Initial Assessment")
	public MedicalHistoryResponse createInitialAssessment(@RequestBody MedicalHistoryRequest request) {
		return medicalHistoryService.createInitialAssessment(request);
	}

}
