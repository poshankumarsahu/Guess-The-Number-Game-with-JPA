package com.example.service;

import com.example.dto.GuessResultDTO;
import com.example.dto.ScoreDTO;
import com.example.entity.ScoreEntity;
import com.example.entity.UserEntity;
import com.example.exception.InputOutOfRangeException;
import com.example.repository.ScoreRepository;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private static final Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final Random random = new Random();

    private Integer numberToGuess;
    private Integer attempts;

    public GameServiceImpl(ScoreRepository scoreRepository, UserRepository userRepository) {
        this.scoreRepository = scoreRepository;
        this.userRepository = userRepository;
        this.attempts = 0;
    }

    @Override
    public GuessResultDTO makeGuess(Integer guess) {
        try {
            if (attempts == 0) {
                numberToGuess = generateRandomNumber();
                logger.info("New game started. Number to guess: {}", numberToGuess);
            }

            if (guess == null) {
                throw new IllegalArgumentException("Guess cannot be null");
            }

            if (guess < 1 || guess > 100) {
                throw new InputOutOfRangeException("Please enter a number between 1 and 100.");
            }

            attempts++;
            logger.info("Attempt {}: User guessed {}", attempts, guess);

            if (guess.equals(numberToGuess)) {
                String message = "Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.";
                saveScore();
                GuessResultDTO result = new GuessResultDTO(message, true, attempts);
                attempts = 0;
                logger.info("Game won. {}", message);
                return result;
            } else if (guess < numberToGuess) {
                return new GuessResultDTO("The number is higher. Try again.", false, attempts);
            } else {
                return new GuessResultDTO("The number is lower. Try again.", false, attempts);
            }
        } catch (Exception e) {
            logger.error("Error in makeGuess: ", e);
            throw new RuntimeException("An error occurred while processing your guess", e);
        }
    }

    @Override
    public List<ScoreDTO> getScoresForCurrentUser() {
        UserEntity user = getCurrentUser();
        return scoreRepository.findByUserOrderByScoreAsc(user).stream()
                .map(score -> new ScoreDTO(score.getId(), score.getScore()))
                .collect(Collectors.toList());
    }

    private void saveScore() {
        UserEntity user = getCurrentUser();
        ScoreEntity score = new ScoreEntity();
        score.setUser(user);
        score.setScore(attempts);
        scoreRepository.save(score);
    }

    private Integer generateRandomNumber() {
        return random.nextInt(100) + 1;
    }

    private UserEntity getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}