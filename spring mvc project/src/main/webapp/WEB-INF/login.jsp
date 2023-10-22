<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login Page</h2>
<% String m = (String) request.getAttribute("msg"); 

if(m!=null){
	out.print("<h2>"+m+"<h2>");
}

%>


<form action="checkLogin" method="post">
<input type = "text" name="uname" placeholder="enter username"> <br> <br>
<input type = "password" name="pwd" placeholder="enter password"> <br> <br>
<input type="submit">
</form>
</body>
</html>