package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portal.model.Employee;
import com.portal.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
//to add Employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee,
            HttpServletRequest request) {
    		if (request.getSession().getAttribute("hrEmail") == null) {
    			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    		}
    		Employee newEmployee=employeeService.saveEmployee(employee);
    		return ResponseEntity.ok(newEmployee);
    }

 //to get all the employees   
    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(HttpServletRequest request) {
        if (request.getSession().getAttribute("hrEmail") == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null); 
        }
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    
   //to get employee from given id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id,HttpServletRequest request) {
        if (request.getSession().getAttribute("hrEmail") == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null); 
        }
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
  
    //update the employee
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee,HttpServletRequest request) {

        if (request.getSession().getAttribute("hrEmail") == null) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
    }
    String result = employeeService.updateemployee(id, updatedEmployee);
    return ResponseEntity.ok(result);

}

    //delete the employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id, HttpServletRequest request) {
        if (request.getSession().getAttribute("hrEmail") == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
   
}
