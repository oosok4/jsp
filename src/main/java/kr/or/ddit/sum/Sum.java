package kr.or.ddit.sum;

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
 * Servlet implementation class Sum
 */
@WebServlet("/sumCalculation")
public class Sum extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(Sum.class);
	
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/sum/sumInput.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		int sum = 0;
	
		for (int i = start; i < end+1; i++) {
			sum += i;
		}
		
		logger.debug("{}",sum);
		request.getSession().setAttribute("sumResult",sum);
			
		RequestDispatcher rd = request.getRequestDispatcher("/sum/sumPrint.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
