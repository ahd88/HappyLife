package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DatabaseConnectivity {
	static Connection conn = null;;
	
	static String url = "jdbc:postresql://" + "ec2-54-159-175-38.compute-1.amazonaws.com:5432/";
	static String db_name = "da9e2btploeabr/sslmode=require";
	static String username = "kfjrkfbnuyegkq";
	static String password = "405a4dec0549d4b0c400bf916db2c496a630ca2947a59cc0ff1bae785cc74fad";
	//static String username = "amgo85";
	//static String url = "jdbc:mysql://" + "localhost:3306/";
	//static String db_name = "spring";
	//static String password = "1234";
	
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
