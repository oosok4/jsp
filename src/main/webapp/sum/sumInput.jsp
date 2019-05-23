<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/sumCalculation" method="post">
	start<input type="text" name="start" value ="0"><br>
	end<input type="text" name="end" value ="0"><br>
	
	<button>계산하기</button>
	</form>

</body>
</html>