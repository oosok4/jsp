package kr.or.ddit.encrypt.kisa.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import kr.or.ddit.encrypt.encrypt.kisa.aria.ARIAUtil;

import org.junit.AfterClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARIAUtilTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ARIAUtilTest.class);

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void encryptTest() throws InvalidKeyException, UnsupportedEncodingException {
		/***Given***/
		String plainText = "brown123";
		/***When***/
		//평문을 암호화 시키고
		String encryptText = ARIAUtil.ariaEncrypt(plainText);
		logger.debug("encryptText : {}",encryptText);
		//brown1234: ED4024DC5EB54D47E7041B4FA0A34F3D
		//brown123 : EC957ACAE6C6ADB3A704EC3F4F00DBEE
		
		
		//암호화된 암호문을 복호하 시킨다.
		String decryptText = ARIAUtil.ariaDecrypt(encryptText);
		
		/***Then***/
		assertEquals(plainText, decryptText);

	}

}
