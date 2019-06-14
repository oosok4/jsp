<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<%--application (getServeletContext() ) : requestMap --%>
	<table>
		<tr>
			<th>uri</th>
			<th>요청횟수</th>
			<%
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("www.naver.com", 1);
				map.put("www.google.com",1);
				map.put("www.kakao.com",1);
			
			%>
			<c:forEach items="${map }" var="m">
			<tr>
				<td>${m.key }</td> 
				<td> ${m.value }</td>
			</tr>
			</c:forEach>
			
			
		
	</table>

</body>
</html>