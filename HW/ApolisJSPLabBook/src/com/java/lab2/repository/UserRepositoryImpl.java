package com.java.lab2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


import com.java.lab2.dto.User;
import com.java.util.OracleBaseDao;


public class UserRepositoryImpl extends OracleBaseDao implements UserRepository {

	

	@Override
	public Optional<User> getUserById(Integer custId) {	
	
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM consumers where consumer_num = ?";
			try {
				conn = super.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setObject(1, custId);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String username=rs.getString("consumer_name");
					String address=rs.getString("address");									
					User user=new User(custId, username, address);
					return Optional.of(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
			return Optional.empty();
			
	}



	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> usersList=new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM consumers";
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Integer custId=rs.getInt("consumer_num");
				String username=rs.getString("consumer_name");
				String address=rs.getString("address");									
				User user=new User(custId, username, address);
				usersList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return usersList;
		
	}
	



}
