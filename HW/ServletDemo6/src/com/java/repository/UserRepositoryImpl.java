package com.java.repository;



import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.java.dto.User;

public class UserRepositoryImpl implements UserRepository {

	static Map<String, User> db = new HashMap<>();

	{
		db.put("a", new User("a", "a"));
		db.put("admin", new User("admin", "admin"));
		db.put("user123", new User("user123", "user123"));
	}

	@Override
	public void createUser(User user) {
		if (user != null && user.getUsername() != null) {
			db.put(user.getUsername(), user);
		}
	}

	@Override
	public void updateUser(User user) {
		if (user != null && user.getUsername() != null) {
			db.put(user.getUsername(), user);
		}
	}

	@Override
	public void deleteUser(String username) {
		if (username != null) {
			db.remove(username);
		}

	}

	@Override
	public void deleteUser(User user) {
		if (user != null && user.getUsername() != null) {
			db.remove(user.getUsername());
		}

	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		User user = db.get(username);
		if (user == null) {
			return Optional.empty();
		} else {
			return Optional.of(db.get(username));
		}
	}

	@Override
	public Collection<User> getAllUsers() {
		return db.values();
	}

}
