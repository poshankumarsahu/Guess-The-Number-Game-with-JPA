package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

}
