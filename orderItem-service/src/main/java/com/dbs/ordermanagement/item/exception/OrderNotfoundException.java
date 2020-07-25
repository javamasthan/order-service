package com.dbs.ordermanagement.item.exception;

public class OrderNotfoundException extends RuntimeException {
private static final long serialVersionUID=1l;
	
	private CustomErrorMessage errorMsg;
	
	public OrderNotfoundException(CustomErrorMessage errorMsg) {
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
