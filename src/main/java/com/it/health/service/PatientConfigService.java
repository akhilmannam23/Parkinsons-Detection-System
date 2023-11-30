package com.it.health.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.health.domain.PatientCofig;
import com.it.health.repository.PatientCofigRepository;

@Service
public class PatientConfigService {

	@Autowired
	private PatientCofigRepository patientCofigRepository;

	public List<PatientCofig> get() {
		return patientCofigRepository.getAll();
	}

}
