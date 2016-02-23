<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.mas.em.common.vo.category.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.mas.em.common.vo.category.CategoryMasts"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spendo Login</title>
</head>
<body>
<br>
<br>
<br>
<br/>
<div align="center" class="emlogin">
<form name="login" method="POST" action="/spendo/login/action">

	<table align="center">
	<tr>
	<td><label for="username">Login Name</label></td>
	<td><input name="login" id="username" maxlength="96" tabindex="1" value=""/><br/></td>
	</tr>
	<tr>
	<td>	<label for="passwd">Password</label></td>
	<td><input name="passwd" id="passwd" type="password" maxlength="64" tabindex="2"/></td></tr>
			</table>
	<button type="submit" name="login">
              Submit
            </button>
</form>
</div>
</body>
</html>