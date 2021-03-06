package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IuserService service;
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request객체로부터 사용자 아이디 파라미터 획득
		String userId = request.getParameter("userId");
		
		//사용자 아이디로 사용자 정보를 조화
		UserVo user = service.getUser(userId);
		
		
		
		//조호ㅢ 결과를 request객체에 속성으로 저장
		request.setAttribute("userVo", user);
		logger.debug("userVO : {}", user);
		//화면을 담당하는 /user/user.jsp로 forward
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
			
	}

}
