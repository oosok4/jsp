package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse responese)throws ServletException, IOException {
		//포워드
	 	return "/main.jsp";

	 	//리다이랙트
	 	//redirect
	 	
	 	
	 	//request.getRequestDispatcher("/main.jsp").forward(request, responese);
		
		
	 	
	 	// 기본 -> forward
	 	// redirect :/ main.jsp -> redirect
		// request.getRequestDispatcher([PATH]).forward(request, responese);
		// response.sendRedirect([PATH]);
	}

}
