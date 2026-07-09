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

<h1>WELCOME TO HOME PAGE</h1>

<%
final String URL = "jdbc:mysql://localhost:3306/jdbc?user=root&password=152210";
int UserId = Integer.parseInt(request.getParameter("UserId"));
String querry = "select * from emp where userid=?";

try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(URL);
	PreparedStatement ps = con.prepareStatement(querry);
	ps.setInt(1,UserId);
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()){
		%>
		<h3>Id: <%=rs.getInt(1) %> </h3>
		<h3>Userid: <%=rs.getInt(2) %> </h3>
		<h3>FirstName: <%=rs.getString(3) %> </h3>
		<h3>LastName: <%=rs.getString(4) %> </h3>
		<h3>Age: <%=rs.getInt(5) %> </h3>
		<h3>City: <%=rs.getString(6) %> </h3>
		
		<% 
	}
	else{
		%>
		<h4>Invalid User id</h4>
		<%
	}
	
	con.close();
	ps.close();
	rs.close();
	
     
}catch(Exception e){
	e.printStackTrace();
}

%>

</body>
</html>