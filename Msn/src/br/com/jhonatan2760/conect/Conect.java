package br.com.jhonatan2760.conect;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conect {

	private final String user = "loader222";
	private final String password = "jhonatan@r7.com";
	private final String url = "jdbc:mysql://exemplo222222.mysql.uhserver.com/exemplo222222";
	
	public Conect(){
	}
	
	public Connection retrieveConection(){
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" registered driver ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = (Connection) DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
