package com.it.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.health.dto.CareGiverDto;
import com.it.health.service.CareGiverService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/care-giver")
@RestController
@Tag(name = "Controller - As a CareGiver, I want to use the application to monitor the progression of Parkinson's disease"
		+ " in a loved one and receive recommendations for managing symptoms.")
public class CareGiverController {

	@Autowired
	private CareGiverService careGiverService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@Operation(summary = "Get Patient details")
	public List<CareGiverDto> get(@RequestParam("patient-email") String patientEmail) {
		return careGiverService.get(patientEmail);
	}

}
