import static org.junit.Assert.*;

import java.util.UUID;

import kr.or.ddit.servlet.util.partUtil;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PartUtilTest {
	private static final Logger logger = LoggerFactory
			.getLogger(PartUtilTest.class);

	@Test
	public void getFileNameTest() {
		/***Given***/
		String contnetDisposition = "form-data; name=\"profile\"; filename=\"sally.png\"";
		/***When***/
		String fileName = partUtil.getFileName(contnetDisposition);

		/***Then***/
		assertEquals("sally.png", fileName);

	}
	
	@Test
	public void uuidTest(){
		/***Given***/

		/***When***/
		logger.debug("UUID.randomUUID().toString() : {}",UUID.randomUUID().toString()); 
		/***Then***/

		
	}
	
	@Test 
	public void getExtTest(){
		/***Given***/
		String filename =  "sally.png";
		String filename2 =  "sally.picture.png";
		String filename3 =  "sally";
		
		/***When***/
		
		String ext = partUtil.getExt(filename);
		String ext2 = partUtil.getExt(filename2);
		String ext3 = partUtil.getExt(filename3);
		
		/***Then***/
		assertEquals("png", ext);
		assertEquals("png", ext2);
		assertEquals("", ext3);

	}
	
	@Test
	public void subStringTest(){
		/***Given***/
		String yyyyMM = "201906";
		/***When***/
		String yyyy = yyyyMM.substring(0,4);
		String mm = yyyyMM.substring(4,6);

		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);

	}
	
	

}
