package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.paging.model.PageVo;


@WebServlet("/lprodList")
public class LprodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private IlprodService service;
   
   @Override
	public void init() throws ServletException {
	   service = new LprodServiceImpl();
   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		
		if(page==null||pageSize == null){
			page = "1";
			pageSize = "5";
		}
		PageVo pageVo = new PageVo(Integer.parseInt(page),Integer.parseInt(pageSize));
		
		Map<String, Object> resultMap = service.lprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>)resultMap.get("lprodList");
		int pagenationSize = (Integer)resultMap.get("paginationSize");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", pagenationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/lprod/lprodList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
