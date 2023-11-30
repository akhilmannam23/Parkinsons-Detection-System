package com.it.health.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.health.dto.DataScientistDto;
import com.it.health.service.DataScientistService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/data-scientist")
@RestController
@Tag(name = "Controller - As a Data Scientist, I want to access to a user friendly interface to experiement with various "
		+ "machine learning algorithms and features for improving the accuracy of Parkinson's "
		+ "disease prediction.")
public class DataScientistController {

	@Autowired
	private DataScientistService DataScientistService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@Operation(summary = "Get All")
	public List<DataScientistDto> get() {
		return DataScientistService.get();
	}

}
