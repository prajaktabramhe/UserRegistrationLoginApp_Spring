package com.bridgelabz.userregistrationlogin.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.userregistrationlogin.dto.ForgotPasswordDTO;
import com.bridgelabz.userregistrationlogin.dto.LoginDTO;
import com.bridgelabz.userregistrationlogin.dto.RegisterDTO;
import com.bridgelabz.userregistrationlogin.model.UserRgisterModel;
import com.bridgelabz.userregistrationlogin.repository.UserRegisterationRegisterRepository;
import com.bridgelabz.userregistrationlogin.util.TokenUtil;

@Service
public class LoginService implements ILoginService{

	@Autowired
	TokenUtil tokenUtil;
	
	@Autowired
	UserRegisterationRegisterRepository userRepo;
	
	@Override
	public String loginData(@Valid LoginDTO login) {
		Optional<UserRgisterModel> user = userRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
		if(user.isPresent()) {
			return tokenUtil.createToken(user.get().getId());
		}else {
			return "No Such User Found";
		}
	}
	
	@Override
	public UserRgisterModel registerUserData(RegisterDTO registerDTO) {
		UserRgisterModel userData = new UserRgisterModel(registerDTO);
		return userRepo.save(userData);
	}

	@Override
	public String forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
		if(forgotPasswordDTO.getNewPassword().equals(forgotPasswordDTO.getConfirmPassword())) {
			userRepo.save(new UserRgisterModel(userRepo.findByEmail(forgotPasswordDTO.getEmail()).get(), forgotPasswordDTO.getNewPassword()));
			return "Password Change Successfull, login with your new password";
		}else {
			return "Password and Confirm Password Do Not Match";
		}
	}

}
