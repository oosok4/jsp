<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	//4가지 파라미터를 받아서 ,4 개의 영역에 속성으로 넣어준다.
    	//속성 저장 : scopeAttribute("속성명",속성(객체));
    	//scope객체  : pageContext, request, session, application
    	
    	pageContext.setAttribute("pageAttribute", request.getParameter("pageParam"));
    	request.setAttribute("requestAttribute", request.getParameter("requestParam"));
    	session.setAttribute("sessionAttribute",request.getParameter("sessionParam"));
    	application.setAttribute("applicationAttribute",request.getParameter("applicationParam"));
    	
    	
    	request.getRequestDispatcher("/scope/scopePrint.jsp").forward(request, response);
    %>