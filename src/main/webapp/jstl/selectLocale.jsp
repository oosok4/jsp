<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>

<body>
lang : ${lang }
<form action="${pageContext.request.contextPath}/selectLocale" method="post">
	<h2>select locale</h2>
	
	<select id="langStr" name="lang" onchange="this.form.submit()">
		<option value="ko" <c:if test="${lang eq 'ko' }"> selected </c:if>>한국어</option>
		<option value="en" <c:if test="${lang eq 'en' }"> selected </c:if>>english</option>
		<option value="ja" <c:if test="${lang eq 'ja' }"> selected </c:if>>日本語</option>
	</select>
	 
	<c:choose>
		<c:when test="${lang eq 'ko' }">
			<fmt:setLocale value="ko" />
			<fmt:bundle basename="kr.or.ddit.msg.msg">
				<fmt:message key="GREETING" />
				<br>
				<fmt:message key="VISITOR">
					<fmt:param value="brown" />
					<br>
				</fmt:message>
			</fmt:bundle>

		</c:when>

		<c:when test="${lang eq 'en' }">
			<fmt:setLocale value="en" />
			<fmt:bundle basename="kr.or.ddit.msg.msg">
				<fmt:message key="GREETING" />
				<br>
				<fmt:message key="VISITOR">
					<fmt:param value="brown" />
					<br>
				</fmt:message>
			</fmt:bundle>

		</c:when>

		<c:when test="${lang eq 'ja' }">
			<fmt:setLocale value="ja" />
			<fmt:bundle basename="kr.or.ddit.msg.msg">
				<fmt:message key="GREETING" />
				<br>
				<fmt:message key="VISITOR">
					<fmt:param value="brown" />
					<br>
				</fmt:message>
			</fmt:bundle>

		</c:when>

	</c:choose>
	
	</form>

	





</body>
</html>