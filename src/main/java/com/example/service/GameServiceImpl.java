package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.ScoreDTO;
import com.example.entity.ScoreEntity;
import com.example.entity.UserEntity;
import com.example.exception.InputOutOfRangeException;
import com.example.repository.ScoreRepo;
import com.example.repository.UserRepo;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ScoreRepo scoreRepo;

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

	@Override
	public String saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserEntity res = userRepo.save(user);
		return "User saved with id : "+ res.getUserid();
	}

	@Override
	public List<ScoreDTO> getScoresForUser(UserEntity currentUser) {
		// TODO Auto-generated method stub

		    List<ScoreEntity> scores = scoreRepo.findByUserOrderByScoreIdDesc(currentUser);
		    
		    // Create an empty list to hold the ScoreDTOs
		    List<ScoreDTO> scoreDTOs = new ArrayList<>();

		    // Loop through each GameScore
		    for (ScoreEntity score : scores) {
		        // Check if the score object is not null
		        if (score != null) {
		            // Extract the ID and score, and create a new ScoreDTO object
		            ScoreDTO dto = new ScoreDTO(score.getScoreId(), score.getScore());
		            // Add the new ScoreDTO to the list
		            scoreDTOs.add(dto);
		        }
		    }

		    // Return the list of ScoreDTOs
		    return scoreDTOs;
		}

}
