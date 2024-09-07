package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.ScoreEntity;
import com.example.entity.UserEntity;

public interface ScoreRepo extends JpaRepository<ScoreEntity, Long> {

	 List<ScoreEntity> findByUserOrderByScoreIdDesc(UserEntity user);
	 
}
