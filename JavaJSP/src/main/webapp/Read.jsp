<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
</head>
<body>
  <%
  final String url = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
  final String querry ="select * from emp";
  
  try{
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection con = DriverManager.getConnection(url);
	  PreparedStatement ps = con.prepareStatement(querry);
	  
	  ResultSet rs = ps.executeQuery();
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
	  
	  <% while(rs.next()){%>
	  
	  <tr>
	  <td><%=rs.getInt(1) %></td>
	  <td><%=rs.getInt(2) %></td>
	  <td><%=rs.getString(3) %></td>
	  <td><%=rs.getString(4) %></td>
	  <td><%=rs.getInt(5) %></td>
	  <td><%=rs.getString(6) %></td>
	  </tr>
		  
	 <% } %>
	  </table>
	  
	  
	  <%  
  }catch(Exception e){
	  e.printStackTrace();
  }
  %>
  
  <style>
  table,th,td{
  border:2px solid black;
  border-collapse:collapse;
  align-item:center;
  padding:10px
  }
  </style>
  
</body>
</html>