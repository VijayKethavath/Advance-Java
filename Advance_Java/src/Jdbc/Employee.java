package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) {
	final String  url ="jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
		
		try {
			
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			
			String table ="create table  if not exists Employee("
					+ "id INT PRIMARY KEY,"
					+ "Name VARCHAR(50),"
					+ "Dept VARCHAR(50))";
			stmt.executeUpdate(table);
			
			String querry = "insert into employee values (1,'Devi','CEO'),"
					+ "(2,'Deva','Manager'),"
					+ "(3,'Alivelu','HR')";
			
			int rows = stmt.executeUpdate(querry);
			System.out.println(rows + " Rows inserted...");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
