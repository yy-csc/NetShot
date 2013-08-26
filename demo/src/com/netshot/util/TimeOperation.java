package com.netshot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeOperation {

	/**
	 * Description: Get current date.
	 * 
	 * @param null
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getCurrentDate() throws ParseException {
		Date currentTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new java.util.Date());
		currentTime = sdf.parse(time);
		return currentTime;
	}
	

//	public static Date getBeforeDate(Date date, int days) throws ParseException {
//		Date beforeTime = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date beforeDate = new Date(date.getTime() - days * 24 * 60 * 60 * 1000);
//		String time=sdf.format(beforeDate);
//		beforeTime = sdf.parse(time);
//		return beforeTime;
//	}
//
//	public static Date getAfterDate(Date date, int days) throws ParseException {
//		Date afterTime = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date afterDate = new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
//		String time=sdf.format(afterDate);
//		afterTime = sdf.parse(time);
//		return afterTime;
//	}
	
	public static Date getBeforeDate(Date date,int days) throws ParseException
	{
		Date beforeTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();   
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR) - days);
		String time=sdf.format(calendar.getTime());
		beforeTime = sdf.parse(time);
		return beforeTime;
	}
	
	public static Date getAfterDate(Date date,int days) throws ParseException
	{
		Date afterTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();   
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR) + days);
		String time=sdf.format(calendar.getTime());
		afterTime = sdf.parse(time);
		return afterTime;
	}
}