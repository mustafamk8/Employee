<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String m = (String) request.getAttribute("msg"); 
 String uu = (String)request.getAttribute("user");

%>
<%@include file="adminHeader.jsp" %>
<%if(uu!=null){ %>
<h1>welcome <%= uu%> </h1>
<%}else{
	response.sendRedirect("index");
}	
	%>

</body>
</html>