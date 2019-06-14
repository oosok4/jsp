<%@tag import="kr.or.ddit.prod.dao.ProdDaoImpl"%>
<%@tag import="kr.or.ddit.prod.dao.IprodDao"%>
<%@tag import="kr.or.ddit.lprod.service.IlprodService"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.lprod.model.LprodVo"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name= "prod_lgu" required="true" %>

<%
	IprodDao dao = new ProdDaoImpl();
	jspContext.setAttribute("prodList", dao.prodList(prod_lgu));
%>

<select>
	<c:forEach items="${prodList }" var="prod">
		<option value="${prod.prod_id }">${prod.prod_name }</option>
	</c:forEach>
</select>


