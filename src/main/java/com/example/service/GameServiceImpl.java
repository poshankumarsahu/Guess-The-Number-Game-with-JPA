package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
	private Integer attempts = 0;

	@Override
    public String getResult(Integer num, UserDetails userDetails) {
        if(num < 0 || num > 100) {
            throw new InputOutOfRangeException("Please Enter number between 0 to 100");
        } else {
            attempts++;
            
            if(randomCalculator == false) {
                random = randomNumber();
                randomCalculator = true;
            }
            
            if(num < random) {
                return "Input Number is less than random number";
            } else if(num > random) {
                return "Input Number is greater than random number";
            } else {
                randomCalculator = false;
                
                // Save score for the authenticated user
                UserEntity currentUser = userRepo.findByUsername(userDetails.getUsername())
                    .orElse(null);
                
                if (currentUser != null && currentUser.getUserid() != null) {
                    ScoreEntity score = new ScoreEntity();
                    score.setUser(currentUser);
                    score.setScore(attempts);
                    try {
                        scoreRepo.save(score);
                        System.out.println("Score saved successfully");
                    } catch (Exception e) {
                        System.err.println("Error saving score: " + e.getMessage());
                    }
                } else {
                    System.out.println("Warning: Attempt to save score for null or transient user");
                }
                
                String result = "Congrats!! You selected the correct Number in " + attempts + " attempts";
                attempts = 0; // Reset attempts for the next game
                return result;
            }
		}
	}

	@Override
	public Integer randomNumber() {
		// TODO Auto-generated method stub
		Integer random = (int) ((Math.random() * 100) + 1);
		return random;
	}

	@Override
	public String saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserEntity res = userRepo.save(user);
		return "User saved with id : " + res.getUserid();
	}

	@Override
	 public List<ScoreDTO> getScoresForUser(UserDetails userDetails){
		// TODO Auto-generated method stub

		UserEntity currentUser = userRepo.findByUsername(userDetails.getUsername())
	            .orElse(null);
	        
	        if (currentUser == null) {
	            return new ArrayList<>(); // Return empty list if user not found
	        }
	        
	        List<ScoreEntity> scores = scoreRepo.findByUserOrderByScoreIdDesc(currentUser);
	        
	        List<ScoreDTO> scoreDTOs = new ArrayList<>();
	        for (ScoreEntity score : scores) {
	            if (score != null) {
	                ScoreDTO dto = new ScoreDTO(score.getScoreId(), score.getScore());
	                scoreDTOs.add(dto);
	            }
	        }
	        return scoreDTOs;
	    }

}
