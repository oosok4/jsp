<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	1.고정 문자열<br>
	 ============================================================================<br>
	2. loop<br>
	<c:forEach begin="1" end="76">=</c:forEach><br>
	3. customTag : <br>
	<ct:logging/><br>
	4. loopCustomTag : <br>
	<ct:loopLogging/><br> 
	5. colorLogguing : <br>
<ct:colorLogging color="blue" size="76"></ct:colorLogging> <br>
<%-- 	6. rangersTag : <ct:ragers ragers = "brown,cony,james,sally,moon"/> --%>
<!-- 	<select> -->
<!-- 		<option>brown</option> -->
<!-- 		<option>cony</option> -->
<!-- 		<option>james</option> -->
<!-- 		<option>sally</option> -->
<!-- 		<option>moon</option> -->
<!-- 	</select> -->
	6. prod : <br>
	<ct:lprod prod_lgu="P302"></ct:lprod>
	
	
	
	
</body>
</html>