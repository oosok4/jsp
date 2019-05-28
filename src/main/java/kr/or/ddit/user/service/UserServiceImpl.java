package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	

}
