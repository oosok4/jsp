<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp scope 테스트</h2>
	<form action="${cp}/scope/scopeReceive.jsp" method="post">
	page <input type="text" name = "pageParam" value="pageValue">
	request <input type="text" name = "requestParam" value="requestValue">
	session <input type="text" name = "sessionParam" value="sessionValue">
	application <input type="text" name = "applicationParam" value="applicationValue">
	<button>전송하기</button>
	</form>
</body>
</html>