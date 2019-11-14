package com.prashant.springsecurity.oauthserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prashant.springsecurity.oauthserver.domain.User;

public interface UserRepo  extends JpaRepository<User, Long>{

	   @Query("SELECT DISTINCT user FROM User user " +
	            "INNER JOIN FETCH user.authorities AS authorities " +
	            "WHERE user.username = :username")
	    User findByUsername(@Param("username") String username);
}
