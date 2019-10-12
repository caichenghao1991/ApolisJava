package com.java.lab3.service;

import com.java.lab3.dao.RegisterDAOImpl;
import com.java.lab3.dto.User;

public class RegisterServiceImpl {
	RegisterDAOImpl impl=new RegisterDAOImpl();
	public boolean createUser(User user) {		
		return impl.createUser(user);
	}
}
