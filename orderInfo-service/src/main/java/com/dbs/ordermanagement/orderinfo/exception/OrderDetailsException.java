package com.dbs.ordermanagement.orderinfo.exception;

public class OrderDetailsException extends RuntimeException {
	private static final long serialVersionUID=1l;
	
	private CustomErrorMessage errorMsg;
	
	public OrderDetailsException(CustomErrorMessage errorMsg) {
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
