package com.dbs.ordermanagement.item.exception;

public class DataBaseException extends Exception {
private CustomErrorMessage errorMsg;
	
	public DataBaseException(CustomErrorMessage errorMsg) {
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
