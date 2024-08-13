package com.javaproject.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateHandler {
	
	public static String formatDate(LocalDateTime dateToFormat) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
		String formattedDate = dateToFormat.format(formatter);
		return formattedDate;
	}
	
	public static boolean dateValidator(String date) {
		String regularExperssion = "(\\d?)(\\d?)(-)(\\d?)(\\d?)(-)(\\d?)(\\d?)(\\d?)(\\d?)?"; 
		Pattern pattern = Pattern.compile(regularExperssion);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

}
