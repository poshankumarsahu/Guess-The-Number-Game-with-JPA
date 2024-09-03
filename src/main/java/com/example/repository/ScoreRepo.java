package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ScoreEntity;

public interface ScoreRepo extends JpaRepository<ScoreEntity, Long> {

}
