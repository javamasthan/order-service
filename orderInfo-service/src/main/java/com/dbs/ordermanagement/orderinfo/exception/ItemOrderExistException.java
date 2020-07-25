package com.dbs.ordermanagement.orderinfo.exception;

public class ItemOrderExistException extends RuntimeException {
private CustomErrorMessage errorMsg;
	
	public ItemOrderExistException(CustomErrorMessage errorMsg) {
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
