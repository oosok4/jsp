<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td{
		width : 100px;
		height: 50px;
		text-align: center;
		border: 1px solid black;
	}
</style>
</head>
<body>
<%
	String param = request.getParameter("i");
	String param2 = request.getParameter("j");
	
%>

<table>
<% 
	for(int i = 1; i<Integer.parseInt(param); i++){
%>
<tr>
x<%=i %>
<% 
	for(int j = 2; j<Integer.parseInt(param2); j++){ 
%>
<td><%=j %>x<%=i %>=<%=i*j %></td>
		
<%
	} 
%>
	</tr>
<%
	} 
%>

</table>

<!-- localhost/jsp/jsp/timesTable.jsp -->
<!-- 9*9단 출력 (2~9단) -->

</body>
</html>