package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoTest.class);
	
	private IuserDao userDao;
	
	
	//junit 실행순서
	//@Beforeclass가 적용딘 메소드가 1회 실행
	
	//다음구간은 @Test가 적용된 모든 메소드에 대해 반복 적용
	//@Before가 적용된 메소드 실행
	//@After가 적용된 메소드가 실행
	
	//@AfterClass가 적용된 메소드가 1회 실행
	
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("boforeClass");
	}
	
	
	
	@Before
	public void setup(){
		logger.debug("setup");
		userDao = new UserDaoImpl();
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	
	
	/**
	 * 
	* Method : userListTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {

		int i = 2;
        int j = 5;
        int k = 3;
		
		int[] array;
		array = new int[]{10,9,8,7,6};
		
		
		

		
	}
	
	@Test
	public void getUserTest(){
		/***Given***/
		IuserDao userDao = new UserDaoImpl();
		String userId = "sally";
		
		/***When***/
		UserVo uv = userDao.getUser(userId);

		/***Then***/
		assertEquals("셀리", uv.getName());
	}
	
	// 사용자 페이징 리스트 조회
	// 고려사항
	// 몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여줄 건지 : 쿼리실행 파라미터
	// 정렬순서 ? : 로직 --> 파라미터화 시킬 수 있다.
	// --> 우리는 사용자 아이디 순으로 정렬
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingList(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);
		

		/***When***/
		List<UserVo> userList = userDao.userpagingList(pageVo);
		

		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());

	}
	
	/**
	 * 
	* Method : usersCntTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :사용자 전체수 조회 테스트
	 */
	@Test
	public void usersCntTest(){
		/***Given***/
		
		/***When***/
		int usersCnt =  userDao.usersCnt();
		/***Then***/
		assertEquals(105, usersCnt);
		
	}
	
	@Test
	public void getAllLprod(){
		/***Given***/
		IlprodDao dao = new LprodDaoImpl();
		
		/***When***/
		List<LprodVo> lprodList = dao.lprodList();
		
		/***Then***/
		
		logger.debug("lprodList : {}",lprodList);
	}
	
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertUserTest() {
		/***Given***/
		//사용자정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo =null;
		
		try {
			userVo = new UserVo("민호", "oosok2", "마이노", "1234", "인천", "대전", "5432", sdf.parse("1993-10-08"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		/***When***/
		int result = userDao.insertUser(userVo);
		

		/***Then***/
		assertEquals(1, result);
		
		userDao.deleteUser(userVo.getUserId());

	}
}




