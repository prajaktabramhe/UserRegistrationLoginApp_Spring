package com.bridgelabz.userregistrationlogin.service;


import com.bridgelabz.userregistrationlogin.dto.ForgotPasswordDTO;
import com.bridgelabz.userregistrationlogin.dto.LoginDTO;
import com.bridgelabz.userregistrationlogin.dto.RegisterDTO;
import com.bridgelabz.userregistrationlogin.model.UserRgisterModel;
import com.bridgelabz.userregistrationlogin.util.Response;

public interface ILoginService {

	Response loginData(LoginDTO login);

	Response registerUserData(RegisterDTO registerDTO);
	
	Response forgotPassword(ForgotPasswordDTO forgotPasswordDTO);

}
