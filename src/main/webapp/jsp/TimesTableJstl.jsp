<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
th,td {
	width: 100px;
	height: 50px;
	text-align: center;
	border: 1px solid black;
}
</style>
</head>
<body>
${i } : 



<c:set var="param" value="${param.i }" scope="request"/>
<c:set var="param2" value="${param.j }" scope="request"/>
	구구단을 외자!

	<table border="1">
		<tr>
			<th>2단</th>
			<th>3단</th>
			<th>4단</th>
			<th>5단</th>
			<th>6단</th>
			<th>7단</th>
			<th>8단</th>
			<th>9단</th>
		</tr>
		<tr>
		<c:forEach begin="1" end="${param.i }" var="i"> 
			<c:forEach begin="2" end="${param.j }" var="j">
				<td>${param.j }* ${param.i } = ${param.i*param.j }</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>

</body>
</html>