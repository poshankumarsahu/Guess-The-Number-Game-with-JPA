package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.ScoreDTO;
import com.example.entity.UserEntity;

@Service
public interface GameService {
	
	public String getResult(Integer num);
	
	public Integer randomNumber();

	public String saveUser(UserEntity user);

	public List<ScoreDTO> getScoresForUser(UserEntity currentUser);

}
