package com.ems.ems_backend.service;

import java.util.List;

import com.ems.ems_backend.dto.EmployeeDto;
import com.ems.ems_backend.entity.Employee;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
    
	void deleteEmployee(Long employeeId);
	
	 List<Employee> testRepository();
}
