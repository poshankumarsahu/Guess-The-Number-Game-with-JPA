package com.example.controller;

import com.example.dto.GuessRequestDTO;
import com.example.dto.GuessResultDTO;
import com.example.dto.ScoreDTO;
import com.example.service.GameService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/guess")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<GuessResultDTO> guess(@RequestBody GuessRequestDTO guessRequest) {
        logger.info("Received guess: {}", guessRequest.getGuess());
        try {
            GuessResultDTO result = gameService.makeGuess(guessRequest.getGuess());
            logger.info("Guess result: {}", result);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Error processing guess: ", e);
            throw e;
        }
    }

    @GetMapping("/scores")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ScoreDTO>> getScores() {
        List<ScoreDTO> scores = gameService.getScoresForCurrentUser();
        return ResponseEntity.ok(scores);
    }
}