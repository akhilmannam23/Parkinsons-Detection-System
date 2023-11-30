package com.it.health.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.health.domain.MedicalHistoryPatientInfo;

@Repository
public interface MedicalHistoryPatientInfoRepository
		extends PagingAndSortingRepository<MedicalHistoryPatientInfo, Long>,
		JpaSpecificationExecutor<MedicalHistoryPatientInfo> {

	@Transactional
	@Modifying
	@Query(value = "Delete from MedicalHistoryPatientInfo Where patientEmail=:patientEmail")
	void deleteByPatientEmail(@Param("patientEmail") String patientEmail);

}
