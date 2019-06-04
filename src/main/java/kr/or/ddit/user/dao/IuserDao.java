package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserDao {
	
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	List<UserVo> userList();
	
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :사용자 한명 조회
	 */
	UserVo getUser(String userId);
	
	/**
	 * 
	* Method : userpagingList
	* 작성자 : PC17
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :사용자 페이징 리스트 조회
	 */
	List<UserVo> userpagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	 */
	int usersCnt();
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 :사용자 등록
	 */
	int insertUser(UserVo userVo);
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :
	 */
	int updateUser(UserVo userVo);


	/**
	 * 
	* Method : userListForPassEncrypt
	* 작성자 : PC17
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 적용대상 전체 조회
	 */
	List<UserVo> userListForPassEncrypt(SqlSession sqlSession);

	
	/**
	 * 
	* Method : updateUserEncryptPass
	* 작성자 : PC17
	* 변경이력 :
	* @param sqlSession
	* @param userVo
	* @return
	* Method 설명 :사용자 비밀번호 암호화적용
	 */
	int updateUserEncryptPass(SqlSession sqlSession, UserVo userVo);
	

}
