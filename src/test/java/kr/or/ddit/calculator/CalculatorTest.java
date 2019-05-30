package kr.or.ddit.calculator;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void empty_test() {
		/***Given***/
		Calculator cal = new Calculator();
		String text = "";
		/***When***/
		int result = cal.calculate(text);

		/***Then***/
		assertEquals(0, result);

	}
	
	@Test
	public void null_test() {
		/***Given***/
		Calculator cal = new Calculator();
		String text = null;
		/***When***/
		int result = cal.calculate(text);
		
		/***Then***/
		assertEquals(0, result);
		
	}
	
	@Test
	public void regexpCaptureTest(){
		/***Given***/
		String text = "//;\n1;5;10;20";
		/***When***/
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text); 
		
		m.find();
		String customSeperator = m.group(1);
		String textNembers =m.group(2);
		
		/***Then***/
		assertEquals(";", customSeperator);
		assertEquals("1;5;10;20", textNembers);
		
	}
	@Test
	public void custom_default_seperatorTest(){
		/***Given***/
		Calculator cal  = new Calculator();
		String text = "//;\n1,5;10:20";
		
		/***When***/
		int result = cal.calculate(text);

		
		/***Then***/
		assertEquals(36, result);

	}
	
	
	@Test
	public void customSeperatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "//;\n1;5;10;20";
		/***When***/
		int result = cal.calculate(text);

		/***Then***/
		assertEquals(36, result);

	}
	
	@Test
	public void defaultSeperatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "1,5:10,20";
		/***When***/
		int result = cal.calculate(text);

		/***Then***/
		assertEquals(36, result);

		
	}

}
