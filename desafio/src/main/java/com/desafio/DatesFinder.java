package com.desafio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class DatesFinder {
	
	public String findDates(Long id, List<LocalDate> dates, String start, String end, String archivoOut) throws ParseException {
		List<LocalDate> completeDates = new ArrayList<LocalDate>();
		List<LocalDate> inDates = new ArrayList<LocalDate>();
		List<LocalDate> notFoundDates = new ArrayList<LocalDate>();
		
		for (int i = 0; i < dates.size(); i++){
			System.out.println(dates.get(i));
			inDates.add(formatDateLD(dates.get(i).toString()));
		}
		
		System.out.println(dates);
		System.out.println(start);
		System.out.println(end);
		
		LocalDate iniCalendar = formatDateLD(start);
		LocalDate finCalendar = formatDateLD(end);
		LocalDate iterateCalendar = formatDateLD(start);
		
		System.out.println(iniCalendar);
		System.out.println(finCalendar);
		System.out.println(iterateCalendar);
		
		int x = 0;
		while(!iterateCalendar.equals(finCalendar)) {
			completeDates.add(iterateCalendar);
			System.out.println(iterateCalendar.toString() + " /// " + finCalendar.toString());
			iterateCalendar = iterateCalendar.plusMonths(1);
			//x++;
		}
		completeDates.add(finCalendar);
		
		System.out.println(completeDates);
		
		for (int j = 0; j < completeDates.size(); j++){
			//System.out.println(completeDates[j]);
			if (inDates.contains(completeDates.get(j))) {				
			}
			else {
				notFoundDates.add(completeDates.get(j));
			}
		}
		
		System.out.println(notFoundDates);
		
		Writer writer = new Writer();
		writer.escribirArchivo(id, iniCalendar, finCalendar, notFoundDates, archivoOut);
		
		return null;		
	};
	
	public static LocalDate formatDateLD(String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}
	
	public static String formatToString(Calendar date) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//Calendar cal  = Calendar.getInstance();
		//String stringDate = date.toString();
		String stringDate =  date.get(Calendar.YEAR) + "-" +  date.get(Calendar.MONTH)
			+ "-" +  date.get(Calendar.DATE);
		return stringDate;
	}

}
