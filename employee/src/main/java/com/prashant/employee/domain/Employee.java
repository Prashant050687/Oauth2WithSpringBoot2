package com.prashant.employee.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DynamicUpdate(true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="Employee")
public class Employee extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8067210052397923732L;

	@NotNull
	@Column(name = "first_name")
	String firstName;
	@NotNull
	@Column(name = "last_name")
	String lastName;
	@NotNull
	@Column(name = "dob")
	@JsonFormat(pattern = "dd.MM.yyyy")
	LocalDate dateOfBirth;
	@NotNull
	@Column(name = "employee_id", unique = true)
	Long employeeId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

}
