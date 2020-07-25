package com.dbs.ordermanagement.orderinfo.exception;

public class DateConverstionException extends Exception {
private CustomErrorMessage errorMsg;
	
	public DateConverstionException(CustomErrorMessage errorMsg) {
		super();
		this.errorMsg=errorMsg;
		
	}

	public CustomErrorMessage getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(CustomErrorMessage errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
