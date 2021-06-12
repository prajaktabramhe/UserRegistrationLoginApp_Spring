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


@RestController
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO login){
		ResponseDTO responseDTO = new ResponseDTO("Login Successfully", loginService.loginData(login));
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> registerUserData(@Valid @RequestBody RegisterDTO registerDTO){
		ResponseDTO responseDTO = new ResponseDTO("User Registration Successfully", loginService.registerUserData(registerDTO));
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/forgotpassword")
	public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgotPasswordDTO forgotPasswordDTO) {
		return new ResponseEntity<String>(loginService.forgotPassword(forgotPasswordDTO) , HttpStatus.OK);
	}
	
}
