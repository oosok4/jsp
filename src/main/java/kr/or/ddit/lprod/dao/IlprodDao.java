package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

public interface IlprodDao {
	
	/**
	 * 
	* Method : lprodList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : lprod 목록 가져오기
	 */
	List<LprodVo> lprodList();
	
	List<LprodVo> lprodpagingList(PageVo pageVo);
	
	int lprodCnt();
	

}
