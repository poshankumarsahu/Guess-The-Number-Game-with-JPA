package com.example.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScoreDTO {

	
	public ScoreDTO(Long id, int score) {
		super();
		this.id = id;
		this.score = score;
	}
	
	private Long id;
    private int score;
}
