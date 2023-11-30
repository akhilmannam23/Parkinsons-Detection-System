package com.it.health.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.it.health.domain.MedicalHistoryQuestionsEntity;

@Repository
public interface MedicalHistoryQuestionsEntityRepository extends PagingAndSortingRepository<MedicalHistoryQuestionsEntity, Long>,JpaSpecificationExecutor<MedicalHistoryQuestionsEntity>{
	
	@Query(value = "select mhqe from MedicalHistoryQuestionsEntity mhqe")
	List<MedicalHistoryQuestionsEntity> getAll();
	
}
