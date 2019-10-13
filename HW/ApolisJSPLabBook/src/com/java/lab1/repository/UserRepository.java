package com.java.lab1.repository;


import java.util.Optional;

import com.java.lab1.dto.User;
//Loose coupling: interface
public interface UserRepository {

	public Optional<User> getUserByUsername(String username,Integer custId);

}
