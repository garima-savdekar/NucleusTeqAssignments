package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
