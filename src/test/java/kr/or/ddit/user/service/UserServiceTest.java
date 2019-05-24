package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	private IuserService userService;
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("boforeClass");
	}
	
	IuserDao userDao = new UserDaoImpl();
	
	@Before
	public void setup(){
		logger.debug("setup");
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	@Test
	public void userListTest() {
		/***Given***/
		IuserService service  = new UserServiceImpl();
		
		/***When***/
		List<UserVo> userList = service.userList();
		
		/***Then***/
		assertEquals("브라운", userList.get(0).getName());
		logger.debug("userList  : {}",userList);
		
	}
	
	@Test
	public void getUserTest(){
		/***Given***/

		
		/***When***/
		
		UserVo uv  = userService.getUser("brown");

		/***Then***/
		logger.debug("uv : {}",uv);

	}

}
