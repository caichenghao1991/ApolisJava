package com.java.lab2.repository;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.java.lab2.dto.User;
//Loose coupling: interface
public interface UserRepository {

	public Optional<User> getUserById(Integer custId);
	public ArrayList<User> getAllUsers();
}
