<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.spendo.commons.vo.json.*" %>
<%@ page import="org.spendo.commons.vo.json.ExpCategory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.spendo.commons.vo.json.ExpCategory"%>
<%@page import="java.util.List"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spendo Category Page</title>
</head>
<body>
<% Object hSession = session.getAttribute("username");
if(hSession==null) {
	response.sendRedirect("http://localhost:8080/EMClient/login/login.jsp");
}
%>
Welcome <%=session.getAttribute("username") %>!
<div align="center" class="category">
<p>This is category manager page</p>
<form name="category" action="http://localhost:8080/spendo/EMCategoryController.do">
	<input type="submit" name="action" value="LoadCategories"/>
	</form>
</div>
<table>
<tr bordercolor="blue">
	<td> CategoryID</td>
	<td> CategoryName</td>
</tr>
<%-- <% 
List<ExpCategory> categoryMastList = ;
for(int row=0; row < categoryMastList.size(); row++) { %>
    <TR>
        <TD> <%=categoryMastList.get(row).getID()%>
        </TD>
        <TD><%=categoryMastList.get(row).getName()%>
        </TD>
    </TR>
<% } %>
 --%></TABLE>
</body>
</html>