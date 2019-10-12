package com.java.lab3.dao;



import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.java.lab3.dto.User;

public class RegisterDAOImpl extends OracleBaseDao {


	public boolean createUser(User user) {		
		if (user != null && user.getFirstname()!= null && user.getLastname()!= null 
				&& user.getPassword()!= null && user.getGender()!= null && user.getSkillSet()!=null && user.getCity()!=null) {
	
			String g=String.valueOf(user.getGender());
			int flag=executeUpdate("insert into registeredusers values(?,?,?,?,?,?)",user.getFirstname(),
					user.getLastname(),user.getPassword(),g,user.getSkillSet(),user.getCity());
			if(flag==1) {
				return true;
			}				
		}
	return false;
	}
	
}
