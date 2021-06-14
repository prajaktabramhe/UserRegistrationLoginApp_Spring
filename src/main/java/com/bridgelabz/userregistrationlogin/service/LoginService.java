package com.bridgelabz.userregistrationlogin.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.userregistrationlogin.dto.ForgotPasswordDTO;
import com.bridgelabz.userregistrationlogin.dto.LoginDTO;
import com.bridgelabz.userregistrationlogin.dto.RegisterDTO;
import com.bridgelabz.userregistrationlogin.exception.UserRegisterationLoginException;
import com.bridgelabz.userregistrationlogin.model.UserRgisterModel;
import com.bridgelabz.userregistrationlogin.repository.UserRegisterationRegisterRepository;
import com.bridgelabz.userregistrationlogin.util.Response;
import com.bridgelabz.userregistrationlogin.util.TokenUtil;

@Service
public class LoginService implements ILoginService{

	@Autowired
	TokenUtil tokenUtil;
	
	@Autowired
	UserRegisterationRegisterRepository userRepo;
	
	@Override
	public Response loginData(@Valid LoginDTO login) {
		Optional<UserRgisterModel> user = userRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
		if(user.isPresent()) {
			String token= tokenUtil.createToken(user.get().getId());
			return new Response(200, "Token Created Succefully", token);
		}else {
			throw new UserRegisterationLoginException(400, "No such User Found");
		}
	}
	
	@Override
	public Response registerUserData(RegisterDTO registerDTO) {
		UserRgisterModel userData = new UserRgisterModel(registerDTO);
		 userRepo.save(userData);
		 return new Response(200, "Saved Succefully", null);
	}


	@Override
	public Response forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		if(forgotPasswordDTO.getNewPassword().equals(forgotPasswordDTO.getConfirmPassword())) {
			
			userRepo.save(new UserRgisterModel(userRepo.findByEmail(forgotPasswordDTO.getEmail()).get(), forgotPasswordDTO.getNewPassword()));
			return new Response (200,"Password Change Successfull, login with your new password", null);
		}else {
			return new Response(400, "Password and Confirm Password Do Not Match", null);
		}
	}

}
