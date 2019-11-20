package com.prashant.employee;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.prashant.employee.domain.Employee;
import com.prashant.employee.repo.EmployeeRepo;

/**
 * 
 *Data loader to load sample employee data into the database.
 * @author prashant
 *
 */
@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  EmployeeRepo employeeRepo;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Employee employeeDTO = new Employee();
    employeeDTO.setFirstName("First Name");
    employeeDTO.setLastName("Last Name");
    employeeDTO.setDateOfBirth(LocalDate.of(1987, Month.JUNE, 05));
    employeeDTO.setEmployeeId(1L);
    employeeRepo.save(employeeDTO);

    Employee employeeDTO2 = new Employee();
    employeeDTO2.setFirstName("First Name2");
    employeeDTO2.setLastName("Last Name2");
    employeeDTO2.setDateOfBirth(LocalDate.of(1987, Month.JUNE, 05));
    employeeDTO2.setEmployeeId(2L);
    employeeRepo.save(employeeDTO2);
  }

}
