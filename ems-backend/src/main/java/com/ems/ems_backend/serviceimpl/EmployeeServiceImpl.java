package com.ems.ems_backend.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.ems_backend.dto.EmployeeDto;
import com.ems.ems_backend.entity.Employee;
import com.ems.ems_backend.exception.ResourceNotFoundException;
import com.ems.ems_backend.mapper.EmployeeMapper;
import com.ems.ems_backend.repository.EmployeeRepository;
import com.ems.ems_backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployee(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with ID :" + employeeId));
		return EmployeeMapper.mapToEmployee(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployee(employee))
				.collect(Collectors.toList());
	}

	
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

	    Employee employee = employeeRepository.findById(employeeId).orElseThrow(
	            () -> new ResourceNotFoundException("Employee doesn't exist with given id:" + employeeId)
	    );

	    employee.setFirstName(updatedEmployee.getFirstName());
	    employee.setLastName(updatedEmployee.getLastName());
	    employee.setEmail(updatedEmployee.getEmail());

	    Employee updatedEmployeeObj = employeeRepository.save(employee);

	    return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee doesn't exist with the given ID :" + employeeId)
				);
		
		employeeRepository.deleteById(employeeId);
	}
	
	@Override // Added the method implementation.
    public List<Employee> testRepository() {
        return employeeRepository.findAll();
    }

}
