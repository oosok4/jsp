package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gugu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter gu = resp.getWriter();
		
		//localhost/jsp/gugu?param=6
		String param = req.getParameter("i");
		String param3 = req.getParameter("j");
		System.out.println("param : " + param);
		int param2 = Integer.parseInt(param);
		int param4 = Integer.parseInt(param3);
		
		int dan;
		int gob;
		gu.write("<head>");
		gu.write("<style>");
		gu.write("td{width : 100px; height : 50px; border : solid 1px black; text-align : center;}");
		gu.write("</style>");
		gu.write("</head>");
		
		gu.write("<table>");
		
		for (int i = 1; i < param4+1; i++) {
			gu.write("<tr>");
			for (int j = 2; j < param2+1; j++) {
				
				gu.write("<td>"+j+"*"+i+"="+i*j);
			}
			gu.write("</tr>");
		}
		gu.write("</table>");
		gu.close();
				
		
	}

	
}
