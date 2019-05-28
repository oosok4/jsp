package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
public static String cookieString; //분석한 쿠키 문자열

	
	/**
	 * 
	* Method : setCookieString
	* 작성자 : PC17
	* 변경이력 :
	* @param cookieString
	* Method 설명 : 분석할 쿠키 문자열을 받는다
	 */
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString;
	}


	/**
	 * 
	* Method : getCookie
	* 작성자 : PC17
	* 변경이력 :
	* @param cookieString2
	* @param string
	* @return
	* Method 설명 : 쿠키 문자열에서 특정 쿠키값을 가져온다ㅣ
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	
	public static String getCookie(String cookie) {
		
		String[] cookieArray =  cookieString.split("; ");
		String cookieValue = "";
		for(String str : cookieArray){
			logger.debug("cookieArray : {}",str);
			if(str.startsWith(cookie)&&str.split("=")[0].equals(cookie)){//&&str.split("=")[0].equals(cookie)
				String[] cookieStr = str.split("=");
				cookieValue = cookieStr[1];
				break;
			}
		}
		return cookieValue;
	}
//		public static String getCookie(String cookie) {
		
		
//		//"userId = brown; rememberme=true; test=testValue";
//		//cookie = "userId"
//		
//		 String[] value = cookieString.split("; ");
//		 
//		 String value1 = value[0].split("=")[0];
//		 String value2 = value[1].split("=")[0];
//		 String value3 = value[2].split("=")[0];
//		
//		if(cookie.equals(value1)){
//			return value[0].split("=")[1];
//		}else if(cookie.equals(value2)){
//			return value[1].split("=")[1];
//		}else if(cookie.equals(value3)){
//			return value[2].split("=")[1];
//		}else{
//			return null;
//		}
		
		
		
//	}

}

