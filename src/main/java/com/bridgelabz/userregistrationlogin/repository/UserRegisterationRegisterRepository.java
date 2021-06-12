package com.bridgelabz.userregistrationlogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.userregistrationlogin.model.UserRgisterModel;

@Repository
public interface UserRegisterationRegisterRepository extends JpaRepository<UserRgisterModel, Integer> {

	Optional<UserRgisterModel> findByEmailAndPassword(String email, String password);
	
	Optional<UserRgisterModel> findByEmail(String email);
}
