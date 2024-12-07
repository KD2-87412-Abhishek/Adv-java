package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {

	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/kdacdb";
	public static final String DB_USER = "kd2_87243_kartik";
	public static final String DB_PASSWD = "manager";

	static {
		try 
		{
			Class.forName(DB_DRIVER);	
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
		return con;
	}
	
}
