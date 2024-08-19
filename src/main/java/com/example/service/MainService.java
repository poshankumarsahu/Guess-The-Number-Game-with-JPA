package com.example.service;

import org.springframework.stereotype.Service;

@Service
public interface MainService {
	
	public String getResult(Integer num);
	
	public Integer randomNumber();

}
