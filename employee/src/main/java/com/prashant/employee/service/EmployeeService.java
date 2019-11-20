package com.prashant.employee.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.prashant.employee.domain.Employee;
import com.prashant.employee.dto.EmployeeDTO;
import com.prashant.employee.exception.BusinessException;
import com.prashant.employee.repo.EmployeeRepo;

/**
 * Employee Service class
 * @author prashant
 *
 */
@Service
public class EmployeeService {

  @Autowired
  EmployeeRepo employeeRepo;

  @Autowired
  @Qualifier("dozerWithMapping")
  DozerBeanMapper dozerWithMapping;

  @Transactional(readOnly = true)
  @PreAuthorize("hasAuthority('READ_EMPLOYEE')")
  public EmployeeDTO findEmployeeById(Long employeeId) {
    Employee employee = employeeRepo.findById(employeeId).orElse(null);
    if (employee == null) {
      throw new BusinessException("Employee Not Found", "Employee with id: " + employeeId + " not found");
    } else {
      return dozerWithMapping.map(employee, EmployeeDTO.class);
    }
  }

  @Transactional(readOnly = true)
  @PreAuthorize("hasAuthority('READ_ALL_EMPLOYEE')")
  public Page<EmployeeDTO> findAllEmployees(Pageable pageable) {
    Page<Employee> employees = employeeRepo.findAll(pageable);
    return employees.map(this::convertDtoPage);
  }

  private EmployeeDTO convertDtoPage(Employee employee) {
    return dozerWithMapping.map(employee, EmployeeDTO.class);
  }

  @Transactional(propagation = Propagation.REQUIRED)
  @PreAuthorize("hasAuthority('CREATE_EMPLOYEE')")
  public void createEmployee(EmployeeDTO employeeDTO) {
    employeeRepo.save(dozerWithMapping.map(employeeDTO, Employee.class));
  }

}
