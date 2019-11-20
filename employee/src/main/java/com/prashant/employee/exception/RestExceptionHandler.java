package com.prashant.employee.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handler advice which intercepts all exceptions and populates ErrorDetail
 * json object as a default response.
 * @author prashant
 *
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

  public static final String APPLICATION_ERROR_JSON = "application/error+json";

  @ExceptionHandler(BusinessException.class)
  public HttpEntity<ErrorDetail> handleBusinessException(BusinessException e, final HttpServletRequest request) {

    ErrorDetail problem = new ErrorDetail(e.getSummary(), e.getMessage());
    problem.setStatus(HttpStatus.NOT_FOUND.value());

    return new ResponseEntity<>(problem, updateContentType(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public HttpEntity<ErrorDetail> handleHttpMessageNotReadableException(HttpMessageNotReadableException e,
    final HttpServletRequest request) {

    final ErrorDetail problem = new ErrorDetail("Message cannot be converted",
      String.format("Invalid request body: %s", e.getMessage()));
    problem.setStatus(HttpStatus.BAD_REQUEST.value());

    return new ResponseEntity<>(problem, updateContentType(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public HttpEntity<ErrorDetail> handleAccessDeniedException(AccessDeniedException e,
    final HttpServletRequest request) {

    final ErrorDetail problem = new ErrorDetail(
      "Access Denied - You do not have permission to access the operation", e.getMessage());
    problem.setStatus(HttpStatus.FORBIDDEN.value());

    return new ResponseEntity<>(problem, updateContentType(), HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
  public HttpEntity<ErrorDetail> handleCredentialsNotFound(AuthenticationCredentialsNotFoundException e,
    final HttpServletRequest request) {

    final ErrorDetail problem = new ErrorDetail(
      "Access Denied - You do not have permission to access the operation", e.getMessage());
    problem.setStatus(HttpStatus.FORBIDDEN.value());

    return new ResponseEntity<>(problem, updateContentType(), HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(javax.validation.ConstraintViolationException.class)
  public HttpEntity<ErrorDetail> handleConstraintViolationsFromJavax(javax.validation.ConstraintViolationException e,
    final HttpServletRequest request) {

    final ErrorDetail problem = new ErrorDetail("Constraint Violation", e.getMessage());
    problem.setStatus(HttpStatus.CONFLICT.value());

    return new ResponseEntity<>(problem, updateContentType(), HttpStatus.CONFLICT);
  }

  /**
   * Handles all unexpected situations
   *
   * @param e any exception of type {@link Exception}
   * @return {@link ResponseEntity} containing standard body in case of errors
   */
  @ExceptionHandler(Exception.class)
  public HttpEntity<ErrorDetail> handleException(Exception e, final HttpServletRequest request) {

    ErrorDetail problem = new ErrorDetail("Internal Error", "An unexpected error has occurred");
    problem.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

    return new ResponseEntity<>(problem, updateContentType(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private HttpHeaders updateContentType() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("Content-Type", APPLICATION_ERROR_JSON);
    return httpHeaders;
  }

}
