package kr.or.ddit.gob;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class Gob
 */
@WebServlet("/mulCalculation")
public class Gob extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(Gob.class);
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/mul/mulInput.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		
		int result = param1 * param2;
		
		
		
		logger.debug("{}*{}={}",param1,param2,result);
		
		request.getSession().setAttribute("mulResult", result);
		RequestDispatcher rd = request.getRequestDispatcher("/mul/mulResult.jsp");
		rd.forward(request, response);
		
		
		
	}

}
