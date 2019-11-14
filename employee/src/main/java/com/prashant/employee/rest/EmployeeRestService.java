package com.prashant.employee.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prashant.employee.dto.EmployeeDTO;
import com.prashant.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestService {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/all")
	public ResponseEntity<Page<EmployeeDTO>> findAllEmployees(Pageable pageable) {
		return ResponseEntity.ok(employeeService.findAllEmployees(pageable));

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findAllEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.findEmployeeById(id));

	}

	@PostMapping(value = "/create")
	public ResponseEntity<Void> createEmployee(  @Valid @RequestBody EmployeeDTO employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}
}
