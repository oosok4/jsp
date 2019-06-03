package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.servlet.util.partUtil;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserFormController
 */
@WebServlet("/userForm")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
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

		// profile파일 업로드 처리

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

			// profile 파일 업로드 처리

			Part profile = req.getPart("profile");

			if (profile.getSize() > 0) {
				// 실제파일명
				String contentDisposition = profile
						.getHeader("content-disPosition");
				String filename = partUtil.getFileName(contentDisposition);
				String ext = partUtil.getExt(filename);

				// partUtil.checkUploadFolder(yyyy, mm);

				String uploadPath = partUtil.getUploadPath();
				File uploadFolder = new File(uploadPath);
				if (uploadFolder.exists()) {
					// 파일 디스크에 쓰기
					String filePath = uploadPath + File.separator
							+ UUID.randomUUID().toString() + ext;
					userVo.setPath(filePath);
					userVo.setFilename(filename);

					profile.write(filePath);
					profile.delete();
				}
			}

			int insertCnt = service.insertUser(userVo);

			if (insertCnt == 1)
				resp.sendRedirect(req.getContextPath() + "/userPagingList");
		} else {
			// req.getRequestDispatcher("/userForm").forward(request, response);
			req.setAttribute("msg", "이미 존재하는 사용자입니다.");
			doGet(req, resp);
		}
	}

}
