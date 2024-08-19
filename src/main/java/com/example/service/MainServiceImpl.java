package com.example.service;

import org.springframework.stereotype.Service;

import com.example.exception.InputOutOfRangeException;

@Service
public class MainServiceImpl implements MainService {

	private boolean randomCalculator = false;
	private Integer random;
	private Integer attempts=0;
	
	@Override
	public String getResult(Integer num) {
		// TODO Auto-generated method stub
		
		   if(num<0 || num>100) {
			   throw new InputOutOfRangeException("Please Enter number between 0 to 100");
		   }else {
			
		    attempts++;
			
			if(randomCalculator==false) {
				random = randomNumber();
				randomCalculator=true;
			}
			
			if(num<random) {
				return "Input Number is less then random number";
			}else if(num>random) {
				return "Input Number is greater then random number";
			}else {
				randomCalculator=false;
				return "Congrats!! You selected the correct Number in "+ attempts + " attempts";
			}
		   }
				
	}

	@Override
	public Integer randomNumber() {
		// TODO Auto-generated method stub
		Integer random = (int) ((Math.random()*100)+1);
		return random;
	}

}
