package com.example.exception;

import org.springframework.security.core.AuthenticationException;

public class CustomJwtAuthenticationException extends AuthenticationException {
    public CustomJwtAuthenticationException(String msg) {
        super(msg);
    }
}
