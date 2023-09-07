package com.newsa.web.domain.services.exceptions;

public class InvalidUsername extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public InvalidUsername(String msg) {
		super(msg);
	}

}
