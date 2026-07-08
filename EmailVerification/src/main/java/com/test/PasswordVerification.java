package com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class PasswordVerification
 */
@WebServlet("/PasswordVerification")
public class PasswordVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String password = request.getParameter("password");
		HttpSession session= request.getSession();
		session.setAttribute("p", password);
		
		String URL = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
		String querry = "select * from email where password=?";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL);
			PreparedStatement ps = con.prepareStatement(querry);
			ps.setString(1,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				 String e = (String) session.getAttribute("e");
				 String p = (String) session.getAttribute("p");
				 
				 response.getWriter().println("<h3> Welcome "+ e +" : " + p +"</h3>");
				 RequestDispatcher rd  = request.getRequestDispatcher("Second.html");
				 rd.include(request,response);	
			}
			else {
				response.getWriter().println("<h3 style='color:red;'>Invalid Details</h3>");
				RequestDispatcher rd  = request.getRequestDispatcher("First.html");
				 rd.include(request,response);
			}
			con.close();
			ps.close();
			rs.close();
			
			
			
		}catch(Exception e) {
		    e.printStackTrace();
		}
		
	}

}
