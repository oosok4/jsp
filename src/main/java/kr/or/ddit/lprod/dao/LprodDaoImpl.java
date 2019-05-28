package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;

public class LprodDaoImpl implements IlprodDao {

//	private IlprodDao dao = new LprodDaoImpl();
		
	
	
	@Override
	public List<LprodVo> lprodList() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVo> lprodList = sqlSession.selectList("lprod.getAllLprod");
		sqlSession.close();
		
		return lprodList;
		
	}

	@Override
	public List<LprodVo> lprodpagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		List<LprodVo> lprodList = sqlSession.selectList("lprod.lprodPagingList",pageVo);
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public int lprodCnt() {
		SqlSession sqlSession  = MyBatisUtil.getSqlSession();
		int lprodCnt = sqlSession.selectOne("lprod.lprodCnt");
		sqlSession.close();
		
		return lprodCnt;
	}
	
	

}
