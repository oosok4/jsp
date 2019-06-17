package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.Dd.model.DdVo;
import kr.or.ddit.Dd.service.DbService;
import kr.or.ddit.Dd.service.IDbService;
import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;

public class RequestMapping {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
	//main.do -> MainComtroller
	// userList.do -> UserListController
	
	//private static Map<String, String> requestMappingClass;
	private static Map<String, Controller>requestMapping;
	private static IDbService service = new DbService();
	
	
	static{
		List<DdVo> urlClassMappingList = service.uriList();
		
		
		/*
		Map<String, String>requestMappingClass = new HashMap<String, String>();
		requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
		//requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
		*/
		
		
		
		requestMapping = new HashMap<String, Controller>();

		for(DdVo uriClassMapping : urlClassMappingList){
			// classInfo : "kr.or.ddit.controller.MainController"
			
			logger.debug("uriClassMapping : {}",uriClassMapping);
			
			String classInfo = uriClassMapping.getClassname();
			
			try {
				Class clazz = Class.forName(classInfo);
				
					Object obj = clazz.newInstance();
					requestMapping.put(uriClassMapping.getUri(), (Controller)obj);
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
		}
		
//		Integer i = new Integer(5);
		
//		requestMapping.put("/main.do", new MainController());
//		requestMapping.put("/userList.do", new UserListController());
		
			
	}

	public static Controller getController(String uri) {
		logger.debug("getController : {}",uri);
		return requestMapping.get(uri);
		
	}
	

}
