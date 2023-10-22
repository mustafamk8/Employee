<%@page import="com.spring.pojo.Student"%>
<%@page import="java.util.ArrayList"%>
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

	<%
	ArrayList<Student> li = (ArrayList<Student>) request.getAttribute("LIST");
	String m = (String) request.getAttribute("msg");
	String uu = (String)request.getAttribute("user");
	
	if (m != null) {
		out.println("<h2 style='color:blue;'" + m + "</h2>");
	}
	%>
	<%if(uu!=null){ %>
<h1>welcome <%= uu%> </h1>
<%}else{
	response.sendRedirect("index");
}	
	%>
	


	<h1>Student Details</h1>
	<table border="2">
		<tr>
			<th>NAME</th>
			<th>ROLL NO</th>
			<th>MARKS</th>
			<th>ADDRESS</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>

		<%
		for (Student ss : li) {
		%>
		<tr>
			<td><%=ss.getName()%></td>
			<td><%=ss.getRollno()%></td>
			<td><%=ss.getMarks()%></td>
			<td><%=ss.getAddress()%></td>
			<td><a href="update_ctrl?roll_no=<%=ss.getRollno()%>"
				onclick=" return confirm ('are you sure want to ypdate')">Update</a></td>
			<td><a href="delete_ctrl?roll_no=<%=ss.getRollno()%>"
				onclick=" return confirm ('are you sure want to delete')">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>