<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
</head>
<body>
<center>
<h3>Fill the Details to add User</h3>

<form action="Save.jsp" method = "post">

<label>User id:</label>
<input type = "text" name = "userid" placeholder = "Number only"><br><br>

<label>First Name:</label>
<input type = "text" name = "fname"><br><br>

<label>Last Name:</label>
<input type = "text" name = "lname"><br><br>

<label>Age:</label>
<input type = "text" name = "age"><br><br>

<label>City:</label>
<input type = "text" name = "city"><br><br>

<input type = "submit" value = "submit">
</form>
</center>

</body>
</html>