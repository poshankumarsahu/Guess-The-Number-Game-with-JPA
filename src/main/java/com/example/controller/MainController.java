package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ScoreDTO;
import com.example.entity.ScoreEntity;
import com.example.entity.UserEntity;
import com.example.repository.ScoreRepo;
import com.example.repository.UserRepo;
import com.example.service.GameService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Main Game Controller", description = "Game Operations")
@RequestMapping(path="/")
public class MainController {

    @Autowired
    private GameService gameService;
    
    

    // home page welcome controller
    @GetMapping(value="")
    public ResponseEntity<String> welcomePage(){
        String res = "Welcome to Guess The Number Game";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    @GetMapping(value="/home")
    public ResponseEntity<String> homePage(){
        String res = "This is Home Page";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    // to save users
    @PostMapping(value="/admin/add")
    public ResponseEntity<String> saveUser(@RequestBody UserEntity user){
    	String res = gameService.saveUser(user);
    	return new ResponseEntity<>(res,HttpStatus.CREATED);
    }

    // controller to enter number by users to play the games 
    @GetMapping(value = "/game/{num}")
    public ResponseEntity<String> numberInput(@PathVariable("num") Integer num, @AuthenticationPrincipal UserDetails userDetails) {
        String res = gameService.getResult(num, userDetails);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    // controller for users game history from db
    @GetMapping("/my-scores")
    public ResponseEntity<List<ScoreDTO>> getMyScores(@AuthenticationPrincipal UserDetails userDetails) {
        List<ScoreDTO> scores = gameService.getScoresForUser(userDetails);
        return ResponseEntity.ok(scores);
    }
    
    
    

    // controller for admin
    @GetMapping(value="/admin")
    public ResponseEntity<String> adminMapping(){
        return ResponseEntity.ok("Welcome Admin!!!");
    }

    // home page controller for users
    @GetMapping(value="/user")
    public ResponseEntity<String> userMapping(){
        String res = "Welcome User!!!";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}