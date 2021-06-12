package com.bridgelabz.userregistrationlogin.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.userregistrationlogin.dto.RegisterDTO;

import lombok.Data;

@Entity
@Table(name = "UserRegister")
@Data
public class UserRgisterModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private Long mobileNumber;
	private LocalTime registrationTime;
	private String email;
	private String password;
	
	public UserRgisterModel () {}
	
	public UserRgisterModel(RegisterDTO registerDTO) {
		this.firstName = registerDTO.getFirstName();
		this.lastName = registerDTO.getLastName();
		this.age = registerDTO.getAge();
		this.mobileNumber = registerDTO.getMobileNumber();
		this.email = registerDTO.getEmail();
		this.password = registerDTO.getPassword();
		this.registrationTime = LocalTime.now();
	}
	
	public UserRgisterModel(UserRgisterModel user,String password) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.age = user.getAge();
		this.mobileNumber = user.getMobileNumber();
		this.email = user.getEmail();
		this.registrationTime = user.getRegistrationTime();
		this.password = password;
	}
	
}
