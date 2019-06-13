<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="size" type="java.lang.Integer" required="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${size == null }">
		<c:set var="s" value="5" />
	</c:when>
	<c:otherwise>
		<c:set var="s" value="${size }" />
	</c:otherwise>
</c:choose>
	<font color="${color }"> <c:forEach begin="1" end="${s }">=</c:forEach>
</font>