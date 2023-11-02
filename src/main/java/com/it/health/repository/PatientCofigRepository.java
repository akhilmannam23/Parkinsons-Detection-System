package com.it.health.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.it.health.domain.PatientCofig;

@Repository
public interface PatientCofigRepository extends PagingAndSortingRepository<PatientCofig, Long>,JpaSpecificationExecutor<PatientCofig>{
	
	@Query(value = "select pc from PatientCofig pc")
	List<PatientCofig> getAll();
	
}
