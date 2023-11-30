package com.it.health.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.it.health.dto.DataScientistDto;

@Service
public class DataScientistService {

	public List<DataScientistDto> get() {
		List<DataScientistDto> dtos = new ArrayList<>();
		
		DataScientistDto dto1 = new DataScientistDto();
		dto1.setMachineLearningAlgorithm("Machine Learning Algorithm 1");
		dto1.setFeature("Machine Learning Feature 1");
		dtos.add(dto1);
		
		DataScientistDto dto2 = new DataScientistDto();
		dto2.setMachineLearningAlgorithm("Machine Learning Algorithm 2");
		dto2.setFeature("Machine Learning Feature 2");
		dtos.add(dto2);
		
		DataScientistDto dto3 = new DataScientistDto();
		dto3.setMachineLearningAlgorithm("Machine Learning Algorithm 3");
		dto3.setFeature("Machine Learning Feature 3");
		dtos.add(dto3);
		
		return dtos;
	}

}
