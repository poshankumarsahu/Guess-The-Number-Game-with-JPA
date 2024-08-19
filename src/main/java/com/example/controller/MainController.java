package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.MainService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Main Controller", description = "Main operations")
@RequestMapping(path="/game")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping(value = "/{num}")
	public ResponseEntity<String> numberInput(@PathVariable("num")Integer num){
		String res = mainService.getResult(num);
		return new ResponseEntity<>(res,HttpStatus.OK);
		
	}
	
	@GetMapping(value="")
	public ResponseEntity<String> home(){
		String res = "Welcome Home 	Bro!!!";
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

}
