package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseConnectivity {
	static Connection conn = null;;
	
	
	//static String username = "";
	//static String url = "jdbc:mysql://" + "localhost:3306/";
	//static String db_name = "";
	//static String password = "";
	
	public static Connection doDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url+db_name, username, password);
		}catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
