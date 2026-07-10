<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<%
RequestDispatcher rd = request.getRequestDispatcher("Read.jsp");
rd.include(request, response);
%>
<br><br>
<form action="UpdateForm.jsp"  method = "post">
<lable>Enter ID to Update :</lable>
<input type = "number" name = "id" required >
<input type = "submit" value = "Update">
</form>

</body>
</html>