package com.it.health.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.health.domain.MedicalHistoryOptionsEntity;
import com.it.health.domain.MedicalHistoryPatientAssessment;
import com.it.health.domain.MedicalHistoryPatientInfo;
import com.it.health.domain.MedicalHistoryQuestionsEntity;
import com.it.health.dto.MedicalHistoryRequest;
import com.it.health.dto.MedicalHistoryResponse;
import com.it.health.repository.MedicalHistoryOptionsEntityRepository;
import com.it.health.repository.MedicalHistoryPatientAssessmentRepository;
import com.it.health.repository.MedicalHistoryPatientInfoRepository;
import com.it.health.repository.MedicalHistoryQuestionsEntityRepository;

@Service
public class MedicalHistoryService {

	@Autowired
	private MedicalHistoryQuestionsEntityRepository medicalHistoryQuestionsEntityRepository;
	@Autowired
	private MedicalHistoryOptionsEntityRepository medicalHistoryOptionsEntityRepository;
	@Autowired
	private MedicalHistoryPatientInfoRepository medicalHistoryPatientInfoRepository;
	@Autowired
	private MedicalHistoryPatientAssessmentRepository medicalHistoryPatientAssessmentRepository;

	public Map<Long, String> getMedicalHistoryQuestions() {
		Map<Long, String> map = new TreeMap<>();
		List<MedicalHistoryQuestionsEntity> list = medicalHistoryQuestionsEntityRepository.getAll();
		for (MedicalHistoryQuestionsEntity mhqe : list) {
			map.put(mhqe.getId(), mhqe.getQuestion());
		}
		return map;
	}

	public Map<Long, String> getMedicalHistoryOptions() {
		Map<Long, String> map = new TreeMap<>();
		List<MedicalHistoryOptionsEntity> list = medicalHistoryOptionsEntityRepository.getAll();
		for (MedicalHistoryOptionsEntity mhoe : list) {
			map.put(mhoe.getId(), mhoe.getOptions());
		}
		return map;
	}

	public MedicalHistoryResponse createInitialAssessment(MedicalHistoryRequest request) {
		
		medicalHistoryPatientInfoRepository.deleteByPatientEmail(request.getPatientEmail());
		
		Date createDate = new Date();
		for (Entry<Long, Long> entry : request.getQuestionOptionMap().entrySet()) {
			MedicalHistoryPatientInfo entity = new MedicalHistoryPatientInfo();
			entity.setCreateDate(createDate);
			entity.setOptionId(entry.getValue());
			entity.setPatientEmail(request.getPatientEmail());
			entity.setQuestionId(entry.getKey());
			medicalHistoryPatientInfoRepository.save(entity);
		}
		
		long count = 0;
		for (Entry<Long, Long> entry : request.getQuestionOptionMap().entrySet()) {
			if(entry.getValue().equals(1l) || entry.getValue().equals(3l)) {
				count++;
			}
		}
		
		String assessment=getAssessment(count);
		String stage = getStage(count);
		
		MedicalHistoryPatientAssessment entity = new MedicalHistoryPatientAssessment();
		entity.setAssessment(assessment);
		entity.setCreateDate(createDate);
		entity.setPatientEmail(request.getPatientEmail());
		entity.setStage(stage);
		medicalHistoryPatientAssessmentRepository.save(entity);
		
		MedicalHistoryResponse response = new MedicalHistoryResponse();
		response.setAssessment(assessment);
		response.setPatientEmail(request.getPatientEmail());
		response.setStage(stage);
		return response;
	}
	
	private String getStage(long count) {
		String stage = "NA";
		if(count==2) {
			stage = "Stage 1";
		} else if(count>2 && count<=5) {
			stage = "Stage 2";
		} else if(count>5 && count<=8) {
			stage = "Stage 3";
		} else if(count>8 && count<=10) {
			stage = "Stage 4";
		} 
		
		return stage;
	}
	
	private String getAssessment(long count) {
		String assessment="No Parkinson's disease (PD). Please do anual checkup for better assessment.";
		if(count==2) {
			assessment = "Parkinson's disease (PD) Stage 1.";
		} else if(count>2 && count<=5) {
			assessment = "Parkinson's disease (PD) Stage 2.";
		} else if(count>5 && count<=8) {
			assessment = "Parkinson's disease (PD) Stage 3.";
		} else if(count>8 && count<=10) {
			assessment = "Parkinson's disease (PD) Stage 4.";
		} 
		return assessment;
	}
	
}
