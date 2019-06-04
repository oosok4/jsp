package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

public class UserServiceImpl implements IuserService{
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);
	
	private IuserDao dao;
	
	public UserServiceImpl(){
		dao = new UserDaoImpl();
	}
	
	
	/**
	 * 사용자 전체리스트 조회
	 */
	@Override
	public List<UserVo> userList() {
		List<UserVo> userList = dao.userList();

		return userList;
	}
	
	/**
	 * 사용자 한명 리스트 조회
	 */
	@Override
	public UserVo getUser(String userId) {
		UserVo uv = new UserVo();
		
		uv = dao.getUser(userId);
		
		
		return uv;
	}


	@Override
	public Map<String, Object> userpagingList(PageVo pageVo) {
		//1. List<UserVo>, userCnt를 필드로 하는 vo
		//2. List<Object> resultList = new ArrayList<Object>();
		// resultList.add(userList);
		// resultList.add(usersCnt);
		//3. Map<String, Object> resultMap = new HashMap<String, Object>();
		// resultMap.put("userList", userList);
		// resultMap.put("usersCnt",usersCnt);
		Map<String, Object>resultMap = new HashMap<String, Object>();
		
		
		//이걸 두개를 한번에 보내는방법은 없다
		resultMap.put("userList",dao.userpagingList(pageVo));
		
		
		
		
		//usersCnt --> paginationSize 변경
		int usersCnt  = dao.usersCnt();
		//pageSize --> pageVo.getPageSize();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		
		return resultMap; 
	}


	@Override
	public int insertUser(UserVo userVo) {
		return dao.insertUser(userVo);
		
	}


	@Override
	public int updateUser(UserVo userVo) {
		return dao.updateUser(userVo);
	}


	/**
	 * 
	* Method : encryptPassAllUser
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 사용자 비밀번호 암호화 일괄 적용 배치
	 */
	@Override
	public int encryptPassAllUser() {
		//사용하지 말것 - 이미 암호화 적용되어있다.
		if(1==1)
			return 0;
		
		
		//0. sql 실행에 필요하 sqlSession 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		//1. 모든 사용자 정보를 조회 (단, 기존 암호화 적용 사용자 제외, brown, userTest)
		List<UserVo> userList = dao.userListForPassEncrypt(sqlSession);
		
		
		int UpdateCntSum = 0;
		//2. 조회된 사용자의 비밀번호를 암호화 적용 후 사용자 업데이트
		for (UserVo userVo : userList) {
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = dao.updateUserEncryptPass(sqlSession,userVo);
			UpdateCntSum += updateCnt;
			
			//비정상
			if(updateCnt != 1){
				sqlSession.rollback();
				break;
			}
			
		}
		sqlSession.commit();
		sqlSession.close();
		
		//3. sqlSession객체를 commit, close.
		return UpdateCntSum;
	}
	
	public static void main(String[] args) {
		IuserService service = new UserServiceImpl();
		int updateCnt = service.encryptPassAllUser();
		logger.debug("updateCnt : {}",updateCnt);
	}
	
	

}
