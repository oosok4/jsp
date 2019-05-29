package kr.or.ddit.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//문자열 계산기
// String test = "1,5,10,20";
// calculate(text) = 36
// 1. 문자열 안에 숫를 구분짓는 구분자를 제거한 남은 숫자들을 전부 던한 값을 구한다.
// 2. 구분자는 두가지가 가능 "," or ":" ex) "1,5:10,20" ==> 36이 나와야 한다.
// 3. 문자열이 공백이거나 , null 이라면 0을 리턴  : "",null ==>0
// 4. 문자열 시작이 "//"과"\n"를 통해 커스텀 구분자를 지정할 수 있다.
// "//;\n1;5;10;20" == > 36
// 5. 숫자 구분자는 커스텀 구분자와 기본 구분자 두가지를 섞어 사용 할 수 있다.

public class Calculator {
	

	public int calculate(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}

		// custom seperator 연산 :
		if (text.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
			if (m.find()) {
				String customSeperator = m.group(1);
				String numberTest = m.group(2);
				String[] numberStrings = numberTest.split(",|:|"+customSeperator);
				int result = 0;
				for (String number : numberStrings) {
					result += Integer.parseInt(number);
				}
				return result;

			}
		}

		// default seperator 연산
		String[] numberStrings = text.split(",|:");
		int result = 0;
		for (String number : numberStrings) {
			result += Integer.parseInt(number);
		}
		return result;

	}

}
