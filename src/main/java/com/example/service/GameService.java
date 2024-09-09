package com.example.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.dto.ScoreDTO;
import com.example.entity.UserEntity;

@Service
public interface GameService {
	
	String getResult(Integer num, UserDetails userDetails);
	
	Integer randomNumber();

	String saveUser(UserEntity user);

	List<ScoreDTO> getScoresForUser(UserDetails userDetails);

}
