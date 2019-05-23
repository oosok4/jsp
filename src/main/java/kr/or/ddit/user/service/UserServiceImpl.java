package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.user.model.UserVo;

public class UserServiceImpl implements IuserService{


	
	/**
	 * 사용자 전체리스트 조회
	 */
	@Override
	public List<UserVo> userList() {
		
		List<UserVo> userList = new ArrayList<UserVo>();
		userList.add(new UserVo("브라운","brown","곰"));
		userList.add(new UserVo("코니","cony","토끼"));
		userList.add(new UserVo("샐리","sally","병아리"));
		userList.add(new UserVo("라이언","james","..."));
		userList.add(new UserVo("제임스","moon","달"));
		
		return userList;
	}
	
	

}
