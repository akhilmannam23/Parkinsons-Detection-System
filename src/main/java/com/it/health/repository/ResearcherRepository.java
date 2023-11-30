package com.it.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.it.health.domain.MedicalHistoryPatientAssessment;

@Repository
public interface ResearcherRepository
		extends PagingAndSortingRepository<MedicalHistoryPatientAssessment, Long>,
		JpaSpecificationExecutor<MedicalHistoryPatientAssessment> {

	@Query(value = "select mh from MedicalHistoryPatientAssessment mh order by createDate desc")
	List<MedicalHistoryPatientAssessment> getAll();

}
