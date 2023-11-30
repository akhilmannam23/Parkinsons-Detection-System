package com.it.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.health.domain.MedicalHistoryPatientAssessment;

@Repository
public interface MedicalHistoryPatientAssessmentRepository
		extends PagingAndSortingRepository<MedicalHistoryPatientAssessment, Long>,
		JpaSpecificationExecutor<MedicalHistoryPatientAssessment> {

	@Query(value = "select mh from MedicalHistoryPatientAssessment mh where mh.patientEmail=:patientEmail order by createDate desc")
	List<MedicalHistoryPatientAssessment> getByPatientEmail(@Param("patientEmail") String patientEmail);

}
