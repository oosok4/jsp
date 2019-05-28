package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.paging.model.PageVo;
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
		userService = new UserServiceImpl();
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
	
	@Test
	public void userPagingList(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		Map<String, Object>resultMap = userService.userpagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		//int usersCnt = (Integer)resultMap.get("usersCnt");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		logger.debug("pagination");
			
		/***Then***/
		
		
		assertEquals(11, paginationSize);
		
		
	}
	
	@Test
	public void ceilTest(){
		/***Given***/

		int usersCnt = 105;
		int pageSize = 10;
		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);	
		logger.debug("pagination : {}",paginationSize);

		/***Then***/
		assertEquals(11, (int)paginationSize);

	}
	
	private IlprodService service;
	
	
	@Test
	public void lprodList(){
		/***Given***/

		service = new LprodServiceImpl();
		/***When***/
		List<LprodVo> lprodList = service.lprodList();

		
		/***Then***/
		logger.debug("lprodList : {}",lprodList);

		
	}

}
