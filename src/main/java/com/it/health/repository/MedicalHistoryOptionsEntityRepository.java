package com.it.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.it.health.domain.MedicalHistoryOptionsEntity;

@Repository
public interface MedicalHistoryOptionsEntityRepository
		extends PagingAndSortingRepository<MedicalHistoryOptionsEntity, Long>,
		JpaSpecificationExecutor<MedicalHistoryOptionsEntity> {

	@Query(value = "select mhoe from MedicalHistoryOptionsEntity mhoe")
	List<MedicalHistoryOptionsEntity> getAll();

}
