package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InputOutOfRangeException.class)
    public ResponseEntity<ExceptionInfo> handleInputOutOfRangeException(InputOutOfRangeException ex) {
        ExceptionInfo info = new ExceptionInfo();
        info.setCode("IOE001");
        info.setMsg(ex.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionInfo> handleAccessDeniedException(AccessDeniedException ex) {
        ExceptionInfo info = new ExceptionInfo();
        info.setCode("AD001");
        info.setMsg("Access denied");
        return new ResponseEntity<>(info, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionInfo> handleBadCredentialsException(BadCredentialsException ex) {
        ExceptionInfo info = new ExceptionInfo();
        info.setCode("BC001");
        info.setMsg("Invalid username or password");
        return new ResponseEntity<>(info, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionInfo> handleRuntimeException(RuntimeException ex) {
        ExceptionInfo info = new ExceptionInfo();
        info.setCode("GE001");
        info.setMsg(ex.getMessage());
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionInfo> handleGeneralException(Exception ex) {
        ExceptionInfo info = new ExceptionInfo();
        info.setCode("GE001");
        info.setMsg("An unexpected error occurred");
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}