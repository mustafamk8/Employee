<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="adminHeader.jsp"%>

	<h1>Registration Form</h1>

	<% String m = (String)request.getAttribute("msg");
		if(m!=null){
		out.println("<h2 style='color:blue;'>"+m+"</h2>");
		}
	%>
	<pre>
	<form action="studentInsert" method="post">
	NAME    : <input type="text" name="name"> <br> <br>
	ROLL NO : <input type="number" name="rollno"> <br> <br>
	MARKS   : <input type="number" name="marks"> <br> <br>
	ADDRESS : <input type="text" name="address"> <br> <br>
	<input type="submit" name="register">
	</form>
</pre>

</body>
</html>