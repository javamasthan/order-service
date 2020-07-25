package com.dbs.ordermanagement.item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemOrderExceptionHandler {
	@ExceptionHandler(value = OrderNotfoundException.class)
	   public ResponseEntity<CustomErrorMessage> exception(OrderNotfoundException exception) {
		 return new ResponseEntity<CustomErrorMessage>(exception.getErrorMsg(), exception.getErrorMsg().getStatus());
	   }
	
	@ExceptionHandler(value = ItemOrderExistException.class)
	   public ResponseEntity<CustomErrorMessage> exception(ItemOrderExistException exception) {
		CustomErrorMessage cem=new CustomErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error Please contact DBC Admin Team!!!");
	     return new ResponseEntity<CustomErrorMessage>(cem, HttpStatus.INTERNAL_SERVER_ERROR);
       
	   }
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	   public ResponseEntity<CustomErrorMessage> exception(HttpMessageNotReadableException exception) {
		CustomErrorMessage cem=new CustomErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Please Provide Fieds in proper format");
     return new ResponseEntity<CustomErrorMessage>(cem, HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	   public ResponseEntity<CustomErrorMessage> exception(HttpRequestMethodNotSupportedException exception) {
		CustomErrorMessage cem=new CustomErrorMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Please select Proper Request Method ");
  return new ResponseEntity<CustomErrorMessage>(cem, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	   }
	
	@ExceptionHandler(value = OrderDetailsException.class)
	   public ResponseEntity<CustomErrorMessage> exception(OrderDetailsException exception) {
  return new ResponseEntity<CustomErrorMessage>(exception.getErrorMsg(), exception.getErrorMsg().getStatus());
	   }
	@ExceptionHandler(value = DataBaseException.class)
	   public ResponseEntity<CustomErrorMessage> exception(DataBaseException exception) {
return new ResponseEntity<CustomErrorMessage>(exception.getErrorMsg(), exception.getErrorMsg().getStatus());
	   }

}
