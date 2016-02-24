<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expenditure Manager Category Page</title>
</head>
<body>
<% Object hSession = session.getAttribute("username");
if(hSession==null) {
	response.sendRedirect("http://localhost:8080/EMClient/em/login/login.jsp");
}
%>
Welcome <%=session.getAttribute("username") %>!
<div align="center" class="emmain">
<form name="emmain" action="http://localhost:8080/EMClient/em/category/categoryinfo.jsp">
	<input type="submit" align="center"  name="action" value="LoadCategories"/>
</form>
</div>
</body>
</html>