package com.java.lab5.repository;


import java.util.Optional;

import com.java.lab5.dto.User;
//Loose coupling: interface
public interface UserRepository {

	public Optional<User> getUserByUsername(String username,Integer custId);

}
