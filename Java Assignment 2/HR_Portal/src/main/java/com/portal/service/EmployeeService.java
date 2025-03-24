package com.portal.service;

import java.util.List;

import com.portal.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployeeById(Long id);
	
	public void deleteEmployee(Long id);
	
	public String updateemployee(Long id,Employee employee);
	

}
