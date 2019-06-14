package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Solution {
	public String solution(String[] participant, String[] completion) {
		
		participant[0] = "일";
		participant[1] = "이";
		participant[2] = "삼";
		participant[3] = "사";
		
		completion[0] = "일";
		completion[1] = "이";
		completion[2] = "삼";
		
		
		Arrays.sort(participant);
		Arrays.sort(completion);

		int i;
		for (i = 0; i < completion.length; i++) {
			if (!(participant[i].equals(completion[i]))) {
				return participant[i];
			}
		}
		return participant[i];
	}
}
