package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDaoImpl;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProdDaoTest.class);
	
	private IprodDao dao;
	
	@Before
	public void setup(){
		logger.debug("setup");
		dao = new ProdDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void prodListtest() {
		/***Given***/
		String prod_lgu = "P201";
		/***When***/
		List<ProdVo> lprodList = dao.prodList(prod_lgu);
		/***Then***/
		logger.debug("lprodList : {}",lprodList);

	}

}
