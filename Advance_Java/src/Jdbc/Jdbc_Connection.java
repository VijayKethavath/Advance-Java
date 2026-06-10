package Jdbc;
import java.sql.Connection;
import java.sql.DriverManager;


public class Jdbc_Connection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/students";
		String username = "root";
		String password = "152210";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection created Successfully");
			
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
