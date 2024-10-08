package com.example.dto;

public class GuessResultDTO {
    private String message;
    private boolean correct;
    private int attempts;

    public GuessResultDTO(String message, boolean correct, int attempts) {
        this.message = message;
        this.correct = correct;
        this.attempts = attempts;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
}