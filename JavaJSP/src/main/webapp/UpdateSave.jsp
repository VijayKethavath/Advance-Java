<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 int id = Integer.parseInt(request.getParameter("id"));
 int userid = Integer.parseInt(request.getParameter("userid"));
 String fname = request.getParameter("fname");
 String lname = request.getParameter("lname");
 int age = Integer.parseInt(request.getParameter("age"));
 String city = request.getParameter("city");

 String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
 String querry = "update emp set userid=?, firstname=?, lastname=?, age=?, city=? where id=?";
 
 try{
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con = DriverManager.getConnection(url);
	 PreparedStatement ps = con.prepareStatement(querry);
	    ps.setInt(1, userid);
		ps.setString(2, fname);
	    ps.setString(3, lname);
	    ps.setInt(4, age);
	    ps.setString(5, city);
	    ps.setInt(6,id);
	    
	    int row = ps.executeUpdate();
	    if(row>0){
	        RequestDispatcher rd = request.getRequestDispatcher("Read.jsp");
	        rd.include(request, response);
	        out.println("<h2>1 Update Successfully</h2>");
	        
	        //response.sendRedirect("Read.jsp");
	    }
	    else{
	    	 out.println("<h2>Update Failed</h2>");
	    }
 }catch(Exception e){
	 e.printStackTrace();
 }
 %>

</body>
</html>