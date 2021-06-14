package com.bridgelabz.userregistrationlogin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.userregistrationlogin.dto.ForgotPasswordDTO;
import com.bridgelabz.userregistrationlogin.dto.LoginDTO;
import com.bridgelabz.userregistrationlogin.dto.RegisterDTO;
import com.bridgelabz.userregistrationlogin.dto.ResponseDTO;
import com.bridgelabz.userregistrationlogin.service.ILoginService;
import com.bridgelabz.userregistrationlogin.util.Response;


@RestController
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody LoginDTO login){
		Response response = loginService.loginData(login);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public ResponseEntity<Response> registerUserData(@Valid @RequestBody RegisterDTO registerDTO){
		Response response= loginService.registerUserData(registerDTO);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/forgotpassword")
	public ResponseEntity<Response> forgotPassword(@Valid @RequestBody ForgotPasswordDTO forgotPasswordDTO) {
		return new ResponseEntity<Response>(loginService.forgotPassword(forgotPasswordDTO) , HttpStatus.OK);
	}
	
}
