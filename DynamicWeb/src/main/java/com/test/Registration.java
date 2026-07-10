package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    int userid = Integer.parseInt(request.getParameter("userid"));
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    int age = Integer.parseInt(request.getParameter("age"));
	    String city = request.getParameter("city");
	    

	   final String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
	   final String querry = "insert into emp (userid,firstname,lastname,age,city) values(?,?,?,?,?)";
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection(url);
	    	PreparedStatement ps = con.prepareStatement(querry);
	    	ps.setInt(1, userid);
	    	ps.setString(2, fname);
	    	ps.setString(3, lname);
	    	ps.setInt(4, age);
	    	ps.setString(5, city);
	    	
	    	int row = ps.executeUpdate();
	    	
	    	if(row>0) {
	    		out.println("<h2>"+row+" row inserted </h2>");
	    	}
	    	
	    	
	    	
	    }catch(Exception e) {
	    	  out.println("<h4>"+e.getMessage()+"<h4>");
	    	  }
	}

}
