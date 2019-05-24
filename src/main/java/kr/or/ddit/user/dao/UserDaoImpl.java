package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDaoImpl implements IuserDao{

	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoImpl.class);
	
	
	public static void main(String[] args) {

		/***Given***/
		IuserDao userDao = new UserDaoImpl();

		/***When***/

		List<UserVo> userList = userDao.userList();
		
		/***Then***/
		logger.debug("userList : {}",userList);

	}

	/**
	 * 
	* Method : userList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	@Override
	public List<UserVo> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		List<UserVo>userList = sqlSession.selectList("user.userList");
				
				
		return userList;
	}

}
