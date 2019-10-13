package com.java.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 数据库连接与关闭工具类
 * 
 * @author Administrator
 * 
 */
public class OracleBaseDao {

	private static String driver="oracle.jdbc.driver.OracleDriver"; // 数据库驱动字符串
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl"; // 连接URL字符串
	private static String name="system"; // 数据库用户名
	private static String password="Cch19911030"; // 用户密码
	Connection conn = null; // 数据连接对象


	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, name, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


	public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public int executeUpdate(String sql, Object... params) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn = getConnection(); // 获取数据库连接
		
		try {
			pstmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					// 为预编译sql设置参数
					pstmt.setObject(i + 1, params[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null); // 关闭数据库连接
		}
		return num;
	}
	public int executeUpdateTransaction(String[] sql, Object[]... params) {
		PreparedStatement pstmt = null;
		int num = 0;
		conn = getConnection(); 
		try {
			conn.setAutoCommit(false);
			for(int i=0;i<sql.length;i++) {
				pstmt = conn.prepareStatement(sql[i]);
				if (params != null && params[i]!=null) {
					for (int j = 0; j < params[i].length; j++) {
						pstmt.setObject(j + 1, params[i][j]);
					}
				}
				num = pstmt.executeUpdate();
			}
			conn.commit();
			
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null); // 关闭数据库连接
		}
		return num;
	}
	
}
