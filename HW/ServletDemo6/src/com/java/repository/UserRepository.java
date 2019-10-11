package com.java.repository;

import java.util.Collection;
import java.util.Optional;

import com.java.dto.User;
//Loose coupling: interface
public interface UserRepository {
	
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(String username);
	public void deleteUser(User username);
	public Optional<User> getUserByUsername(String username);
	public Collection<User> getAllUsers();
}
