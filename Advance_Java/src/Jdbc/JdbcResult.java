package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcResult {

	public static void main(String[] args) {
		 final String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
		 String querry  = "select * from students";
		 
		 try {
			 
			 Connection con = DriverManager.getConnection(url);
			 Statement stmt = con.createStatement();
			 
			 ResultSet resultset = stmt.executeQuery(querry);
			 
			 System.out.println("ID\tName\tLocation\tEmail");
			 System.out.println("-------------------------------------");
			 
			 while(resultset.next()) {
				 int id = resultset.getInt("id");
				 String name = resultset.getString("Name");
				 String Location = resultset.getString("Location");
				 String email = resultset.getString("Email");
				 
				 System.out.println(id+"\t"+name+"\t"+Location+"\t"+email);
			 }
			 
			 con.close();
			 stmt.close();
		 }catch(Exception e) {
			 e.printStackTrace();
			 
		 }

	}

}
