package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.PensionDetail;

@Repository
public interface PensionDetailRepository extends JpaRepository<PensionDetail, Integer>{

}
