package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.PensionerDetail;

@Repository
public interface PensionerDetailRepository extends JpaRepository<PensionerDetail, String> {

}
