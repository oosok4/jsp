package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/selectLocale")
public class SelectLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(SelectLocale.class);

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String lang = request.getParameter("lang");
		
		if (lang == null) {
			lang = "ko";
		}
		request.setAttribute("lang", lang);
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String lang = request.getParameter("lang");

		if (lang == null) {
			lang = "ko";
		}

		request.setAttribute("lang", lang);
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request,response);
	}

}
