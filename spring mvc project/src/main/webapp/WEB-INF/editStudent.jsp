<%@page import="com.spring.pojo.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit Students</title>
</head>
<body>
	<%@include file="adminHeader.jsp"%>

	<h1>Registration Form</h1>

	<% String m = (String)request.getAttribute("msg");
	String uu = (String)request.getAttribute("user");
		if(m!=null){
		out.println("<h2 style='color:blue;'>"+m+"</h2>");
		}
		Student um = (Student)request.getAttribute("STD");
	%>
	<%if(uu!=null){ %>
<h1>welcome <%= uu%> </h1>
<%}else{
	response.sendRedirect("index");
}	
	%>
	
	<pre>
	<form action="updateInsert" method="post">
	NAME    : <input type="text" name="name" value="<%=um.getName() %>" > <br> <br>
	ROLL NO : <input type="number" name="rollno" value="<%=um.getRollno() %>" readonly > <br> <br>
	MARKS   : <input type="number" name="marks" value="<%=um.getMarks() %>"> <br> <br>
	ADDRESS : <input type="text" name="address" value="<%=um.getAddress() %>"> <br> <br>
	<input type="submit" name="register">
	</form>
</pre>

</body>
</html>