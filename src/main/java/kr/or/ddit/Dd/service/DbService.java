package kr.or.ddit.Dd.service;

import java.util.List;

import kr.or.ddit.Dd.Dao.DbDao;
import kr.or.ddit.Dd.Dao.IdbDao;
import kr.or.ddit.Dd.model.DdVo;

public class DbService implements IDbService {
	
	private IdbDao dao;
	
	public DbService(){
		dao = new DbDao();
	}

	@Override
	public List<DdVo> uriList() {

		return dao.uriList();
	}
	
	

}
