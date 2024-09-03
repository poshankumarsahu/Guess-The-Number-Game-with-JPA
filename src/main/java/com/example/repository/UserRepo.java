package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

}
