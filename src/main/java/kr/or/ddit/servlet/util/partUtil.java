package kr.or.ddit.servlet.util;

public class partUtil {

	/**
	 * 
	 * Method : getFileName 작성자 : PC08 변경이력 :
	 * 
	 * @param contentDispositin
	 * @return Method 설명 : contentDisposition에서 파일명을 반환한다.
	 */
	public static String getFileName(String contentDispositin) {
		// content-disposition : form-data; name="profile"; filename="sally.png"
		String[] splited = contentDispositin.split("; ");
		for (String split : splited)
			if (split.startsWith("filename=")) {
				int start = split.indexOf("\"") + 1;
				int end = split.lastIndexOf("\"");
				return split.substring(start, end);
			}
		return "";
	}
	
	/**
	 * 
	 * Method : getExt 작성자 : PC17 변경이력 :
	 * 
	 * @param fileName
	 * @return Method 설명 :파일명으로부터 파일 확장자를 반환
	 */
	public static String getExt(String fileName) {
		String[] splited = fileName.split("[.]");
		if (splited.length == 1)
			return "";
		else
			return splited[splited.length - 1];
	}
	

}