package com.javaproject.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateHandler {
	
	public static boolean dateValidator(String date) {
		String regularExperssion = "(\\d?)(\\d?)(-)(\\d?)(\\d?)(-)(\\d?)(\\d?)(\\d?)(\\d?)?"; 
		Pattern pattern = Pattern.compile(regularExperssion);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

}
