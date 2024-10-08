package com.example.service;

import com.example.dto.UserDTO;
import java.util.List;

public interface AdminService {
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
}