package kr.or.ddit.algorithm;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class programas {

	private static final Logger logger = LoggerFactory
			.getLogger(programas.class);

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void Sticktest() {
		/*** Given ***/

		class Solution {
			public String solution(String[] participant, String[] completion) {
				Arrays.sort(participant);
				Arrays.sort(completion);

				int i;
				for (i = 0; i < completion.length; i++) {
					if (!participant[i].equals(completion[i])) {
						return participant[i];
					}
				}
				return participant[i];
			}
		}

		/*** When ***/

		/*** Then ***/

	}

}
