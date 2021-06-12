package com.bridgelabz.userregistrationlogin.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Data;


public @Data class RegisterDTO {

	@NotBlank(message = "First name cannot be blank")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be blank")
	private String lastName;
	
		
	@NotNull(message = "Age cannot be null")
	private int age;
	
	@NotNull(message = "MobileNumber cannot be null")
	private Long mobileNumber;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
	
	public RegisterDTO () {} 
	
	

}
