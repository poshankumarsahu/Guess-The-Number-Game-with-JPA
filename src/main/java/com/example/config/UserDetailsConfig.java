package com.example.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.UserEntity;
import com.example.repository.UserRepo;

@Service
public class UserDetailsConfig implements UserDetailsService {

	  @Autowired
	    private UserRepo userRepo;

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<UserEntity> user = userRepo.findByUsername(username);
	        if (user.isPresent()) {
	            UserEntity userObj = user.get();
	            return User.builder()
	                .username(userObj.getUsername())
	                .password(userObj.getPassword())
	                .roles(userObj.getRole())
	                .build();
	        } else {
	            throw new UsernameNotFoundException("User not found: " + username);
	        }
	}

}
