package com.bridgelabz.userregistrationlogin.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ForgotPasswordDTO {
	
	@NotNull
	@Email
	private String email;

	@NotNull
	private String newPassword;

	@NotNull
	private String confirmPassword;

}
