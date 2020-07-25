package com.dbs.ordermanagement.orderinfo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomErrorMessage {
	
	String errorMsg;
	private HttpStatus status;
	
	
	
	public CustomErrorMessage(HttpStatus status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}

	

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
	
	

}
