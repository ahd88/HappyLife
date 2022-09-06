package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseConnectivity {
	static Connection conn = null;;
	
	static String url = "jdbc:mysql://localhost:3306/";
	static String db_name = "spring";
	static String username = "amgo85";
	static String password = "sUmhiGW-sFUhvRGQ";
	
	public static Connection doDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url+db_name, username, password);
		}catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
