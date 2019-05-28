package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserPagingList
 */
@WebServlet("/userPagingList")
public class UserPagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IuserService service;
   
	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		
		
		if(page==null||pageSize == null){
			page = "1";
			pageSize = "10";
		}
		PageVo pageVo = new PageVo(Integer.parseInt(page),Integer.parseInt(pageSize));
		
		Map<String, Object>resultMap = service.userpagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int pagenationSize = (Integer)resultMap.get("paginationSize");
		
		//request.setAttribute("pagingList", service.userpagingList(pageVo));
		
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", pagenationSize);
		request.setAttribute("pageVo", pageVo);
		
		
		request.getRequestDispatcher("/user/pagingList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
