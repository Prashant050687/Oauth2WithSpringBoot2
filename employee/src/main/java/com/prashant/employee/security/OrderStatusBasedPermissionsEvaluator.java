package com.prashant.employee.security;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class OrderStatusBasedPermissionsEvaluator implements PermissionEvaluator{
	
	@Autowired
	HttpServletRequest request;

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		boolean hasPrivilege = false;
		if(permission instanceof String) {
			hasPrivilege = request.isUserInRole((String)permission);
		}
		if(null != targetDomainObject && targetDomainObject instanceof Long) {
			if ((Long)targetDomainObject == 1L) {
				return hasPrivilege;
			}else {
				hasPrivilege = false;
			}
		}
		return hasPrivilege;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return false;
	}
	
	

}
