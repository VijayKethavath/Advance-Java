package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedStatement2 {

	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/jdbc?user=root$password=152210";
		String querry = "insert into Employee values (?,?,?)";
		Scanner sc = new Scanner(System.in);
		
		try {
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement(querry);
			
			int count = 1;
			while(count<4) {
				System.out.println("Enter Emp id");
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Emp Dept ");
				String dep = sc.nextLine();
				System.out.println("Enter Emp Email ");
				String email = sc.nextLine();
				
				ps.setInt(1, id);
				ps.setString(2, dep);
				ps.setString(3, email);
				
				int row = ps.executeUpdate();
				System.out.println(row + "Row inserted ..");
				
				}
			
			con.close();
			ps.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
