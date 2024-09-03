package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ScoreEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long scoreId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId",nullable=false)
	private UserEntity user;
	
	@Column(nullable=false)
	private int score;

}
