<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scope객체에 저장한 속성명</h2>
	userId : ${userId} <br>
	requestScope.userId : ${requestScope.userId} <br>
	sessionScope.userId : ${sessionScope.userId} <br>
	
	<%//session.removeAttribute("userId"); %>
	
	<h2>el로 파라미터 접근 - param.파라미터명</h2>
	param.userId : ${param.userId} <br> 


</body>
</html>