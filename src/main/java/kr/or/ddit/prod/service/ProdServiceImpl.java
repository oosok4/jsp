package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IprodDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;

public class ProdServiceImpl implements IprodDao{
	
	private IprodDao dao;
	
	public ProdServiceImpl(){
		dao = new ProdDaoImpl();
	}

	@Override
	public List<String> prodList() {
		return dao.prodList();
	}
	
	

}
