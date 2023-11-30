package com.it.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.health.dto.ResearcherPatientInfoDto;
import com.it.health.service.ClinicianService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/clinician")
@RestController
@Tag(name = "Controller - As a Clinician, I want the application to provide me with a risk assessment score for Parkinson's "
		+ "disease when evaludating patients, assiting in making informed diagonstic decisions.")
public class ClinicianController {

	@Autowired
	private ClinicianService clinicianService;

	@RequestMapping(value = "/get-all", method = RequestMethod.GET)
	@Operation(summary = "Get Patient details")
	public List<ResearcherPatientInfoDto> get() {
		return clinicianService.getAll();
	}

}
