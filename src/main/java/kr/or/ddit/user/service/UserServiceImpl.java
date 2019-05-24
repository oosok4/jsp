package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	

}
