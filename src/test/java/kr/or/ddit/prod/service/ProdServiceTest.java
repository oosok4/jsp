package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.dao.IprodDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.user.service.UserServiceImpl;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProdServiceTest.class);
	
	private IprodService service;
	
	//IprodDao dao = new ProdDaoImpl();
	
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void prodListtest() {
		/***Given***/
		IprodService service= (IprodService) new ProdServiceImpl();
		/***When***/
		List<String> prodList = service.prodList();
		/***Then***/
		logger.debug("prodList : {}",prodList);
	}

}
