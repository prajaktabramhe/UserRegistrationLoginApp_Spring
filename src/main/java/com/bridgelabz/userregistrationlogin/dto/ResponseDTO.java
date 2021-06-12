package com.bridgelabz.userregistrationlogin.dto;

import lombok.Data;

@Data
public class ResponseDTO {


    private int statusCode;
	private String message;
	private Object data;


	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}


}
