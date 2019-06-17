package kr.or.ddit.Dd.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;





import MyBatisUtil.MyBatisUtil;
import ch.qos.logback.core.db.dialect.MySQLDialect;
import kr.or.ddit.Dd.model.DdVo;

public class DbDao implements IdbDao {

	@Override
	public List<DdVo> uriList() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DdVo> DdList = sqlSession.selectList("Dd.getDdAllList");
		sqlSession.close();
		
		return DdList;
	}

}
