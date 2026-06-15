package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/?user=root&password=152210";
		try {
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("create database if not exists JDBC");
			System.out.println("Created");
			
			stmt.executeUpdate("use JDBC");
			
			String table = "create table if not exists students("
					+ " id INT primary key,"
					+ "Name VARCHAR(50),"
					+ "Location VARCHAR(50),"	
					+ "Email VARCHAR(50))";
			
			String querry = "insert into students values (1,'Vijay','KPHB','Vijay@gmail.com'),"
					+ "(2,'Ajay','LB Nagar','Ajay@gmail.com'),"
					+ "(3,'Bruno','Amangal','Bruno@gmail.com')";
			
			int rows = stmt.executeUpdate(querry);
			System.out.println(rows+" Inserted...");
			
			stmt.executeUpdate(table);
			System.out.println("Table Created Successfully");
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
