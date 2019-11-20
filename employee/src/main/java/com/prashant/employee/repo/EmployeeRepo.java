package com.prashant.employee.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prashant.employee.domain.Employee;

/**
 * Spring JPA repository for Employee.
 * @author prashant
 *
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
  @Query(value = "select e from Employee e order by e.id desc")
  Page<Employee> findAll(Pageable pageable);
}
