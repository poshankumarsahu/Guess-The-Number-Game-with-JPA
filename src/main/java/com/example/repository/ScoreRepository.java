package com.example.repository;

import com.example.entity.ScoreEntity;
import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {
    List<ScoreEntity> findByUserOrderByScoreAsc(UserEntity user);
}