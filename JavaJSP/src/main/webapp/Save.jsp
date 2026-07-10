<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

response.setContentType("text/html");


int userid = Integer.parseInt(request.getParameter("userid"));
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
int age = Integer.parseInt(request.getParameter("age"));
String city = request.getParameter("city");

String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
String querry = "INSERT INTO emp(userid, firstname, lastname, age, city) VALUES(?,?,?,?,?)";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url);
	PreparedStatement ps = con.prepareStatement(querry);
	
	ps.setInt(1, userid);
	ps.setString(2, fname);
    ps.setString(3, lname);
    ps.setInt(4, age);
    ps.setString(5, city);
    
    int row = ps.executeUpdate();
    
    if(row>0){
        RequestDispatcher rd = request.getRequestDispatcher("Read.jsp");
        rd.include(request, response);
        out.println("<h2>1 Row Inserted Successfully</h2>");
        
        //response.sendRedirect("Read.jsp");
    }
    else{
    	 out.println("<h2>Insertion Failed</h2>");
    }
}catch(Exception e){
	out.println("<h3>"+e.getMessage()+"</h3>");
}
%>

</body>
</html>