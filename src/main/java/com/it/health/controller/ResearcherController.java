package com.it.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.health.dto.ResearcherPatientInfoDto;
import com.it.health.service.ResearcherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/researcher")
@RestController
@Tag(name = "Controller - As a Researcher, I want to access a database of anonymized patient data to train and validate "
		+ "predictive model for Parkinson's disease.")
public class ResearcherController {

	@Autowired
	private ResearcherService researcherService;

	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@Operation(summary = "Get Patient details")
	public List<ResearcherPatientInfoDto> get() {
		return researcherService.getAll();
	}

}
