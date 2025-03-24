package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.model.HR;


public interface HRRepository extends JpaRepository<HR,Long>{
	HR findByEmail(String email);

}
