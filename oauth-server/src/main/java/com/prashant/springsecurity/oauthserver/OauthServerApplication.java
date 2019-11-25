package com.prashant.springsecurity.oauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EntityScan(basePackages = {"com.prashant.springsecurity.oauthserver.domain"})
@EnableJpaRepositories(basePackages = "com.prashant.springsecurity.oauthserver.repo")
@ComponentScan(basePackages = {"com.prashant.springsecurity"})
public class OauthServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(OauthServerApplication.class, args);
  }

}
