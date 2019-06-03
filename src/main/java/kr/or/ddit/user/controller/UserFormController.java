package kr.or.ddit.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserFormController
 */
@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IuserService service;

	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
	}

	private static final Logger logger = LoggerFactory
			.getLogger(UserFormController.class);

	// 사용자 등록화면 요청치리
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		logger.debug("userForm doPost");

		// 사용자 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
		String userId = req.getParameter("userId");
		String name = req.getParameter("name");
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcd = req.getParameter("zipcd");
		String birth = req.getParameter("birth");
		String pass = req.getParameter("pass");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserVo userVo = null;

		try {
			userVo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd,
					sdf.parse(birth));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVo dbuser = service.getUser(userId);

		// 등록된 사용자가 아닌 경우 --> 정상입력이 가능한 상황
		if (dbuser == null) {
			int insertCnt = service.insertUser(userVo);

			if (insertCnt == 1)
				resp.sendRedirect(req.getContextPath() + "/userPagingList");
		} else {
			// req.getRequestDispatcher("/userForm").forward(request, response);
			req.setAttribute("msg", "이미 존재하는 사용자입니다.");
			doGet(req, resp);
		}

		// 존재하지 않을경우{

		// userService 객체를 통해 insertUser(userVo);

		// 정상적으로 입력이 된 경우
		// 사용자페이징 리스트 1페이지로 이동

		// 정상적으로 입력되지 않은 경우
		// 사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
		// }

		// 존재할 경우
		// 社용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
		// 이미 존재하는 userId입니다.(alert or text로 표시)

	}

}
