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
String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
String querry = "delete from emp where id=?";
try{
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con = DriverManager.getConnection(url);
	 PreparedStatement ps = con.prepareStatement(querry);
	    ps.setInt(1, id);
	    int row = ps.executeUpdate();
	    if(row>0){
	        RequestDispatcher rd = request.getRequestDispatcher("Read.jsp");
	        rd.include(request, response);
	        out.println("<h2>1 Deleted Successfully</h2>");
	        
	        //response.sendRedirect("Read.jsp");
	    }
	    else{
	    	 out.println("<h2>Deleting Failed</h2>");
	    }
}catch(Exception e){
	e.printStackTrace();
}
%>
</body>
</html>