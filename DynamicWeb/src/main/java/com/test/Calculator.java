package com.test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Calcutalor
 */
@WebServlet("/Calculator")
public class Calculator extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    int A = Integer.parseInt(request.getParameter("Aval"));
	    int B = Integer.parseInt(request.getParameter("Bval"));
	    
	    String Op = request.getParameter("val");
	    
	    switch(Op) {
	    case "+":
	    	     System.out.println(A+B);
	    	     out.println("<h1>"+A+" + "+B+" = "+(A+B)+"</h1>");
	    	     break;
	    	     
	    case "/":
	    	System.out.println(A/B);
	    	out.println("<h1>"+A+" / "+B+" = "+(A/B)+"</h1>");
	    	break;
	    	
	    case "-":
	    	System.out.println(A-B);
	    	out.println("<h1>"+A+" - "+B+" = "+(A-B)+"</h1>");
	    	break;
	    	
	    case "*":
	    	System.out.println(A*B);
	    	out.println("<h1>"+A+" * "+B+" = "+(A*B)+"</h1>");
	    	break;
	    	
	    case "%":
	    	System.out.println(A%B);
	    	out.println("<h1>"+A+" % "+B+" = "+(A%B)+"</h1>");
	    	break;
	    	
	    	default:System.out.println("Invalid");break;
	    	
	    }
	}

}
