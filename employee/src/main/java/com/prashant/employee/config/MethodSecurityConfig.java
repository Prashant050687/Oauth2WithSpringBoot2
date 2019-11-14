package com.prashant.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import com.prashant.employee.security.OrderStatusBasedPermissionsEvaluator;

@Configuration
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
	
	 @Bean(name = "customPermissionEvaluator")
	    public OrderStatusBasedPermissionsEvaluator customPermissionEvaluator() {
	        return new OrderStatusBasedPermissionsEvaluator();
	    }
 
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = 
          new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator( customPermissionEvaluator());
        return expressionHandler;
    }
}
