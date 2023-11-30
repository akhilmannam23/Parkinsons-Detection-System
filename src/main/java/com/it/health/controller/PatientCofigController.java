package com.it.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.health.domain.PatientCofig;
import com.it.health.service.PatientConfigService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/patient-config")
@RestController
@Tag(name = "Controller - As a patient, I want application to provide me with resources and support groups for "
		+ "individuals living with Parkinson's disease if I receive a high risk assessment")
public class PatientCofigController {

	@Autowired
	private PatientConfigService patientConfigService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@Operation(summary = "Get all resources and support groups")
	public List<PatientCofig> get() {
		return patientConfigService.get();
	}
	
}
