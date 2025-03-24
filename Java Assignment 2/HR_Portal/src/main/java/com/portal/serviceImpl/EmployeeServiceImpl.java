package com.portal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.model.Employee;
import com.portal.repository.EmployeeRepository;
import com.portal.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public String updateemployee(Long id, Employee employee) {
		Employee existingemployee = getEmployeeById(id);
		existingemployee.setName(employee.getName());
		existingemployee.setDepartment(employee.getDepartment());
		existingemployee.setEmail(employee.getEmail());
		existingemployee.setSalary(employee.getSalary());
		employeeRepository.save(existingemployee);
		return ("Employee Updated successfully");
	}
	

}
