package com.cryptocurrency.backend.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils2 {

	private static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	private static final double MILLISECOND_TO_HOUR = 1000 * 60 * 60;
	private static final double MILLISECOND_TO_DAY=1000*60*60*24;
	private static final double MILLISECOND_TO_MINUTE=1000*60;

	public static long dateToEpochTime(String dateTime) throws ParseException {

		Date dateIn = DATETIME_FORMAT.parse(dateTime);
		long unixTime = dateIn.getTime() / 1000L;

		return unixTime;
	}

	public static String epochTimeToDate(Long unixTime) {

		Date dateTime = new Date(unixTime * 1000L);
		String dateTimeFormatted = DATETIME_FORMAT.format(dateTime);

		return dateTimeFormatted;
	}
	
	public static double calculateEpochTimeToDayAndTime(long unixEpoch1, long unixEpoch2, String option) throws ParseException {

		
		Date date1 = new Date(unixEpoch1 * 1000L);
		Date date2 = new Date(unixEpoch2 * 1000L);
		
		option.toLowerCase();
		String[] findOption=option.split("");
		String setting=findOption[0];
		
			
		switch(setting){
			case "d":
				Double days = (date2.getTime() - date1.getTime()) / MILLISECOND_TO_DAY;
				return days;
			case "h":
				Double hours = (date2.getTime() - date1.getTime()) / MILLISECOND_TO_HOUR;
				return hours;
			case "m":
				Double minutes = (date2.getTime() - date1.getTime()) / MILLISECOND_TO_MINUTE;
				return minutes;
			default:
				System.out.println("ERROR - Not A Valid Input");
				return 0;
		}
	}
		
	// Maybe a Method for Week Number in Calendar Year.
	
	public int getDayOfWeekFromDate(Date date) {
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		int day=cal.get(Calendar.DAY_OF_WEEK);
		
		// May want this to return a String instead of an int/byte
		  switch(day){
			case 1-> System.out.println("Sunday");
			case 2-> System.out.println("Monday");
			case 3-> System.out.println("Tuesday");
			case 4-> System.out.println("Wednesday");
			case 5-> System.out.println("Thursday");
			case 6-> System.out.println("Friday");
			case 7-> System.out.println("Saturday");
			default->System.out.println("error - day doesn't exist");
			}
		 
		
		return day;
	}
	
	public static long convertToEDT(String utcDateTime) throws ParseException {
		long epochDateTime=dateToEpochTime(utcDateTime);
		long epochTimeToEDT=Math.abs(epochDateTime-14400);
		return epochTimeToEDT;
	}
	
}
