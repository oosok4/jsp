package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class UserAdmit
 */
@WebServlet("/userAdmit")
public class UserAdmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserAdmit.class);
       
	private IuserService service;
	
	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		logger.debug("userId : {}",userId);
		
		UserVo user = service.getUser(userId);
		request.setAttribute("userVo", user);
		
		request.getRequestDispatcher("/user/userAdmit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		logger.debug("userForm doPost");
		
		//사용자 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서 
		String userId = request.getParameter("userId");
		String name= request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2= request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		String pass = request.getParameter("pass");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = null;
	
		try {
			userVo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVo dbuser = service.getUser(userId);
		
		//등록된 사용자가 아닌 경우 --> 정상입력이 가능한 상황
		if(dbuser == null){
			int insertCnt = service.insertUser(userVo);
			
			if(insertCnt == 1)
				response.sendRedirect(request.getContextPath()+"/userPagingList");
		}
		else{
			//req.getRequestDispatcher("/userForm").forward(request, response);
			request.setAttribute("msg", "이미 존재하는 사용자입니다.");
			doGet(request,response);
		}
	}

}
