<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.User" %>
 <%@ page import="java.util.List" %>
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all users</title>
<link rel = "stylesheet"
			 type = "text/css"
			href ="../css/style.css"
	/>
</head>
<body>


<div id = "plavaCrta">
		LOGO
	</div>
	<a href = "adminPage.jsp"> back to admin page</a>

		<%
			List<User> useri = new ArrayList<User>();
			
			useri = (List<User>)session.getAttribute("useriIzBaze");
		
		%>

		<h1> TABELA SVIH USERA </h1>

			<table border="1">
				<tr>
					<th>ID</th>
					<th>USER NAME</th>
					<th>PASSWORD</th>
					<th>BALANCE</th>
					<th>ROLA</th>
				</tr> 

		<%	for(User u: useri){ %>
			<tr>
				<td><%=u.getIdUser() %></td>
				<td><%=u.getUserName()%></td>
				<td><%=u.getPassword() %></td>
				<td><%=u.getBalance() %></td>
				<td><%=u.getRola() %></td>
			</tr>
		<%} %>	
		</table>
</body>
</html>