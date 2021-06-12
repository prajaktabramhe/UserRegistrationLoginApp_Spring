package com.bridgelabz.userregistrationlogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bridgelabz.userregistrationlogin.util.Response;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class UserRegistrationLoginExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception e){
		log.error(e.getMessage(), e);
		UserRegisterationLoginException he = new UserRegisterationLoginException(100, e.getMessage());
		return new ResponseEntity<>(he.getErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
