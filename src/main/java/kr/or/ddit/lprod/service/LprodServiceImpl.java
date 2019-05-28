package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

public class LprodServiceImpl implements IlprodService {
	
	private IlprodDao dao;
	
	public LprodServiceImpl(){
		dao  = new LprodDaoImpl();
	}

	@Override
	public List<LprodVo> lprodList() {
		
		return dao.lprodList();
	}

	
	@Override
	public Map<String, Object> lprodPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>(); 
		
		resultMap.put("lprodList", dao.lprodpagingList(pageVo));
		
		int lprodCnt = dao.lprodCnt();
		
		int paginationSize = (int)Math.ceil((double)lprodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

}
