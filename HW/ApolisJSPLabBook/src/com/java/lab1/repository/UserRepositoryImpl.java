package com.java.lab1.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.java.lab1.dto.User;

public class UserRepositoryImpl implements UserRepository {

	static Map<Integer, User> db = new HashMap<>();

	{
		db.put(1, new User(1, "1","1"));
		db.put(100001, new User(100001, "Sumeet","Shivaji Nagar, Pune"));
		db.put(100002, new User(100002, "Meenal","M G Colony Panvel, Mumbai"));
		db.put(100003, new User(100003, "Neeraj","Whitefield, Bangalore"));
		db.put(100004, new User(100004, "Arul","Karapakkam, Chennai"));
	}



	@Override
	public Optional<User> getUserByUsername(String username,Integer custId) {	
		User user = db.get(custId);		
		if (user == null || !username.equals(user.getUsername())) {
			System.out.println(0);
			return Optional.empty();
		} else {	
			System.out.println(user.toString());
			return Optional.of(db.get(custId));
		}
	}



}
