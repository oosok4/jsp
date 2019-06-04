package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserService {
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 :사용자 전체 리스트 조회
	 */
	List<UserVo> userList();
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :사용자 한명 리스트 조회
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
	Map<String, Object> userpagingList(PageVo pageVo);

	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userVo
	* Method 설명 :
	 */
	int insertUser(UserVo userVo);
	
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : PC17
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 :
	 */
	int updateUser(UserVo userVo);
	
	
	/**
	 * 
	* Method : encryptPassAllUser
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 사용자 비밀번호 암호화 일괄 적용 배치
	 */
	int encryptPassAllUser();
	
	
	
	
	
	

}
