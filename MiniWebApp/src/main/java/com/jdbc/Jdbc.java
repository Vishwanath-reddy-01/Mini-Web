package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {

	private static Connection con;

	public static Connection getconnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniweb", "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public void closeConnection() {
		if(this.con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
