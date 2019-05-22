<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//sendRedirect 메소드 인자 값을 웹 브라우저가 수신한 후에 
		// 주소 줄에 그대로 붙여 넣음
		response.sendRedirect(request.getContextPath()+"/jsp/redirectTarget.jsp");
		System.out.println("userId parameter : "+request.getParameter("userId"));
		// jsp/jsp/redirectTarget.jsp 
	%>

</body>
</html>