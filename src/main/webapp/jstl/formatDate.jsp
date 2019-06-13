<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>korea : ko</h2>
	<c:set var="dt" value="<%=new Date()%>"/>
	dt : ${dt }<br>
	dt : <fmt:formatDate value ="${dt }"/><br>
	dt : <fmt:formatDate value ="${dt }" pattern="yyyy-M-dd"/><br>
	dt : <fmt:formatDate value ="${dt }"/><br>
	---<br>
	dt : <fmt:formatDate value ="${dt }" type="date" dateStyle="FULL"/><br>
	dt : <fmt:formatDate value ="${dt }" type="date" dateStyle="MEDIUM"/><br>
	dt : <fmt:formatDate value ="${dt }" type="date" dateStyle="SHORT"/><br>
	---<br>
	dt : <fmt:formatDate value ="${dt }" type="time"/><br>
	dt : <fmt:formatDate value ="${dt }" type="both"/><br>
	
	<h2>germany : de</h2>
	<fmt:setLocale value="de_DE"/>
	dt : <fmt:formatDate value ="${dt }" /><br>
	
	
	<h2>parseDate (String -> date / 2019.6.13 -> date)</h2>
	<fmt:setLocale value="ko_kr"/>
	<c:set value="2019.06.13" var="dtStr"/>
	dtStr  : ${dtStr }<br>
	dtStr : <fmt:parseDate value="${dtStr }" pattern="yyyy.MM.dd" dateStyle="FULL"/><br>


</body>
</html>