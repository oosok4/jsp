package kr.or.ddit.Dd;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.Dd.model.DdVo;
import kr.or.ddit.Dd.service.DbService;
import kr.or.ddit.Dd.service.IDbService;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DdServiceTest {
	
	private IDbService service;
	
	private static final Logger logger = LoggerFactory
			.getLogger(DdServiceTest.class);
	
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		/***Given***/
		IDbService service = new DbService();
		/***When***/
		List<DdVo> ddList = service.uriList();

		/***Then***/
		logger.debug("ddList : {} ",ddList); 
		

	}

}
