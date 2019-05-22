<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
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
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	out.write("application.getContextPath() :" +application.getContextPath()+"<br>");
	out.write("application.getServerInfo() : " +application.getServerInfo()+"<br>");
	out.write("application.getMajorVersion() : " +application.getMajorVersion()+"<br>");
	out.write("application.getMinorVersion() : " +application.getMinorVersion()+"<br>");
	out.write("application.getInitParameter(\"ADMIN\") : " +application.getInitParameter("ADMIN")+"<br>");

	out.write("application.getRealPath(\"res/190522.txt\") : " + application.getRealPath("/res/190522.txt"));
	
	File file = new File("D:/A_TeachingMaterial/6.JspSpring/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/jsp/res/190522.txt");
	FileInputStream fin = new FileInputStream(file); 
	
	InputStreamReader isr = new InputStreamReader(fin, "utf-8");
	
	int c;
	while((c=isr.read()) !=-1){
// 		System.out.print((char)c);
		out.write((char)c);
	}
	
	fin.close();
	
	
	
%>
</body>
</html>