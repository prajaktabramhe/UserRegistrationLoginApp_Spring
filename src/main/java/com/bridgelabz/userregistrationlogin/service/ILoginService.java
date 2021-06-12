package com.bridgelabz.userregistrationlogin.service;


import com.bridgelabz.userregistrationlogin.dto.ForgotPasswordDTO;
import com.bridgelabz.userregistrationlogin.dto.LoginDTO;
import com.bridgelabz.userregistrationlogin.dto.RegisterDTO;
import com.bridgelabz.userregistrationlogin.model.UserRgisterModel;

public interface ILoginService {

	String loginData(LoginDTO login);

	UserRgisterModel registerUserData(RegisterDTO registerDTO);
	
	String forgotPassword(ForgotPasswordDTO forgotPasswordDTO);

}
