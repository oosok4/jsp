package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Date date = new Date();
		PrintWriter pw = resp.getWriter();
//		pw.write(date.toString());
		SimpleDateFormat date2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String date3 = date2.format(date);
		pw.write(date3);
		
		pw.close();
		
	}
	
	

}
