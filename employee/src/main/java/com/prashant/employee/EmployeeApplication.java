package com.prashant.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@ComponentScan(basePackages = {"com.prashant.employee"})
@EntityScan(basePackages = {"com.prashant.employee.domain", "org.springframework.data.jpa.convert.threeten"})
@EnableJpaRepositories(basePackages = "com.prashant.employee.repo")
@EnableSpringDataWebSupport
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
