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
	

   
/*
 * curl -u emoloyee:secret -X POST localhost:7777/oauth/token\?grant_type=password\&username=john\&password=123
 * 
 * This returns the access token for the user john.the token has the info that joh has a role user.
 * 
 * curl localhost:7777/products -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huIiwic2NvcGUiOlsiZm9vIiwicmVhZCIsIndyaXRlIl0sIm9yZ2FuaXphdGlvbiI6ImpvaG5GQ21xIiwiZXhwIjoxNTYyMTYzMzA1LCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMzUxMzNjNWMtMGU1OS00NjM1LTlmYmEtNjBkMzdiNDZmYzA0IiwiY2xpZW50X2lkIjoiZm9vQ2xpZW50SWRQYXNzd29yZCJ9.kVFHRiTxexmNwAoxAeaDF7sxOmqZX4eXH894L_CdOPg"
 * 
 * The abobe command is used to access the endpoint(resource server) with access token of john.
 * But the url needs access with role ADMIN ,hence the url access will be denied.
 */
}
