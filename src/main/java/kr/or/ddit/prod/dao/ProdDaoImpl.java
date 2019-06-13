package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.model.ProdVo;

public class ProdDaoImpl implements IprodDao {
	
	

	@Override
	public List<String> prodList() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<String> lprodList = sqlSession.selectList("prod.getAllLprod");
		sqlSession.close();
		
		return lprodList;
	}

}
