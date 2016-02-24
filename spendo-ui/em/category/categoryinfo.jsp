<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.spendo.commons.vo.json.ExpCategory"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spendo Category Page</title>
</head>
<body>
<div align="center" class="category">
<p>This is category manager page</p>
</div>
<table align="center" border="1">
<tr>
	<td> CategoryID</td>
	<td> CategoryName</td>
	<td> Description</td>
</tr>
<c:forEach items="${allCategoryMasts}" var="categoryMast">    
    <TR>
        <TD> ${categoryMast.id}
        </TD>
        <TD>${categoryMast.name}
        </TD>
        <TD>${categoryMast.description}
        </TD>
    </TR>
</c:forEach>
</TABLE>
<div align="center" class="categoryback">
</div>
</body>
</html>