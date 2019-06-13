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
<%--
	pageContext.setAttribute("num",1000000);와 동일하다
 --%>

<h2>formatNumber (number -> String / 1000000-> 1,000,000)</h2><br>
	<c:set value="1000000.55" var="num"/>
num : ${num }<br><br>

<fmt:setLocale value="ko_kr"/>
korea : ko<br>
<fmt:formatNumber value="${num }"/><br>
<fmt:formatNumber value="${num }" type="currency"/><br>
<fmt:formatNumber value="${num }" type="percent"/><br><br>

<fmt:setLocale value="de_DE"/>
germany : de<br>
<fmt:formatNumber value="${num }"/><br>
<fmt:formatNumber value="${num }" type="currency"/><br>
<fmt:formatNumber value="${num }" type="percent"/><br><br>


<h2>parseNumber (String -> number / 1,000,000 -> 1000000)</h2><br>
<c:set value="1,000,000" var="numStr"/>
<fmt:setLocale value="ko"/>
numStr = ${numStr } <br>
parseNumber numstr : <fmt:parseNumber value="${numStr }" pattern="0,000"/>


</body>
</html>