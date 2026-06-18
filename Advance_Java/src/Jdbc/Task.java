package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Task {

	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
		String querry = "insert into students values (?,?,?,?)";
		Scanner sc = new Scanner(System.in);

		
		int count = 1;

		while(count<3) {
		try {

			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement(querry);

				
				System.out.println("Enter Id:");
		    	   int id = Integer.parseInt(sc.nextLine());
		    	   System.out.println("Enter name :");
		    	   String name = sc.nextLine();
		    	   System.out.println("Enter Location");
		    	   String loc = sc.nextLine();
		    	   System.out.println("Enter Email:");
		    	   String email = sc.nextLine();
		    	   
		    	   ps.setInt(1, id);
		    	   ps.setString(2, name);
		    	   ps.setString(3, loc);
		    	   ps.setString(4, email);
		    	   
		    	   
		    	   int row = ps.executeUpdate();
		    	   System.out.println(row + "Rows inserted");
		    	   
		    	   

			
			
			sc.close();
			con.close();
			ps.close();


		}catch(Exception e) {
			e.printStackTrace();
		}
		count++;
		
	}

	}

}
