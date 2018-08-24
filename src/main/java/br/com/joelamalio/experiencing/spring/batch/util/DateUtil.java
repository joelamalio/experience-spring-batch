package br.com.joelamalio.experiencing.spring.batch.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static final String PATTERN_DD_MM_YYYY = "dd/MM/yyyy";
	
	public static Date formatDate(String pattern, String date) {
		DateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
		}
		return null;
	}
	
	public static Date formatDateDDMMYYYY(String date) {
		return formatDate(PATTERN_DD_MM_YYYY, date);
	}

}
