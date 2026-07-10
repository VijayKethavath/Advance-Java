<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int id = Integer.parseInt(request.getParameter("id"));

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?user=root&password=152210");
	PreparedStatement ps = con.prepareStatement("select * from emp where id=?");
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	
	if(rs.next())
   {
%>
	<table >
	  <tr>
	    <th>ID</th>
	    <th>UserID</th>
	    <th>Fist Name</th>
	    <th>Last Name</th>
	    <th>Age</th>
	    <th>City</th>
	  </tr>
	  
	  <tr>
	  <td><%=rs.getInt(1) %></td>
	  <td><%=rs.getInt(2) %></td>
	  <td><%=rs.getString(3) %></td>
	  <td><%=rs.getString(4) %></td>
	  <td><%=rs.getInt(5) %></td>
	  <td><%=rs.getString(6) %></td>
	  </tr>
	  
	  </table>
	<% 
   }
	else
	{
	    out.println("<h3>No Record Found</h3>");
	}
}catch(Exception e){
	e.getMessage();
}
%>


</body>
</html>