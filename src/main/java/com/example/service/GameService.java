package com.example.service;

import com.example.dto.GuessResultDTO;
import com.example.dto.ScoreDTO;

import java.util.List;

public interface GameService {

    /**
     * Process a user's guess and return the result.
     * 
     * @param guess The number guessed by the user
     * @return GuessResultDTO containing the result of the guess
     */
    GuessResultDTO makeGuess(Integer guess);

    /**
     * Retrieve the scores for the current user.
     * 
     * @return List of ScoreDTO objects representing the user's scores
     */
    List<ScoreDTO> getScoresForCurrentUser();
}