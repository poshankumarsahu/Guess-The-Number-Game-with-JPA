package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=InputOutOfRangeException.class)
	public ResponseEntity<ExceptionInfo> inputOutOfRangeException(InputOutOfRangeException e){
		ExceptionInfo exInfo = new ExceptionInfo();
		exInfo.setCode("IR001");
		exInfo.setMsg(e.getMessage());
		return new ResponseEntity<>(exInfo,HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(CustomAccessDeniedException.class)
	    public ResponseEntity<ExceptionInfo> handleAccessDeniedException(CustomAccessDeniedException ex) {
	        ExceptionInfo exInfo = new ExceptionInfo();
	        exInfo.setCode("AD001");
	        exInfo.setMsg("You do not have permission to access this page.");
	        return new ResponseEntity<>(exInfo, HttpStatus.FORBIDDEN);
	    }
	  
	  /*@ExceptionHandler(AccessDeniedException.class)
	    public ResponseEntity<ExceptionInfo> handleAccessDeniedException(AccessDeniedException ex) {
	        ExceptionInfo exInfo = new ExceptionInfo();
	        exInfo.setCode("AD001");
	        exInfo.setMsg("You do not have permission to access this resource.");
	        return new ResponseEntity<>(exInfo, HttpStatus.FORBIDDEN);
	    }*/
}

