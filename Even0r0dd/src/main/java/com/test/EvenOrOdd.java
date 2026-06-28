package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class EvenOrOdd
 */
@WebServlet("/EvenOrOdd")
public class EvenOrOdd extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public EvenOrOdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		int num = Integer.parseInt(request.getParameter("num"));
		PrintWriter out = response.getWriter();
		
		if(num % 2 == 0) {
			System.out.println(num +" is Even");
			out.println(" <h1>"+num+" is Even</h1>");
		}
		else {
			System.out.println(num +" is Odd");
			out.println(" <h1>"+num+" is Odd</h1>");
		}
		
	}

}
