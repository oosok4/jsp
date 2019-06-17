package kr.or.ddit.Dd;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.Dd.Dao.DbDao;
import kr.or.ddit.Dd.Dao.IdbDao;
import kr.or.ddit.Dd.model.DdVo;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DdDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(DdDaoTest.class);
	
	private IdbDao dao;
	
	@Before
	public void setup(){
		logger.debug("setup");
		dao = new DbDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void DdTesttest() {
		
		/***Given***/

		/***When***/
		List<DdVo> DdList = dao.uriList();
		/***Then***/
		logger.debug("DdList : {}",DdList);

		
	}

}
