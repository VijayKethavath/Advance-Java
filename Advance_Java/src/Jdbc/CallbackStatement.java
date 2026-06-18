package Jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallbackStatement {

	public static void main(String[] args) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
		Scanner sc = new Scanner(System.in);
		
		String querry = "call getID(?)";
		
		Connection con = DriverManager.getConnection(url);
		
		CallableStatement cs = con.prepareCall(querry);
		
		System.out.println("Enter Id to get details");
		int ids = Integer.parseInt(sc.nextLine());
		cs.setInt(1, ids);
		
		ResultSet resultset = cs.executeQuery();
		
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
		cs.close();
		sc.close();
		

	}

}
