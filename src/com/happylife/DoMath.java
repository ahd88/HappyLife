package com.happylife;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class DoMath {

	public DoMath() {
		
	}
	
	public int getAge(Date dobSql) {
		
		long millis = System.currentTimeMillis();  
		Date now = new Date(millis);
		System.out.println("current date in DoMath is " + now);
		System.out.println("Date of Birth in DoMath is " + dobSql);
		
		Calendar dobCal = Calendar.getInstance();
		dobCal.setTime(dobSql);
		int monthOfBirth = dobCal.get(Calendar.MONTH);
		int dayOfBirth = dobCal.get(Calendar.DAY_OF_MONTH);
		int yearOfBirth = dobCal.get(Calendar.YEAR);
		
		Calendar nowCal = Calendar.getInstance();
		int month = nowCal.get(Calendar.MONTH);
		int day = nowCal.get(Calendar.DAY_OF_MONTH);
		int year = nowCal.get(Calendar.YEAR);
		
		System.out.println("Month of now in DoMath is " + month);
		System.out.println("Month of Birth in DoMath is " + monthOfBirth);
		int yearDiff = year - yearOfBirth;
		int monthDiff = month - monthOfBirth;
		int dayDiff = day - dayOfBirth;
		if(dayDiff >= 28)	monthDiff++;
		else if (dayDiff <= -28) monthDiff--;
		
		if(monthDiff >= 11)	yearDiff++;
		else if (monthDiff <= -11) yearDiff--;
		return yearDiff;	
	}
	
	public String getLastLogin(Timestamp ts){
		//Date date = Date.valueOf(ts.toLocalDateTime().toLocalDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		int llYear = cal.get(Calendar.YEAR);
		int llMonth = cal.get(Calendar.MONTH);
		int llDay = cal.get(Calendar.DAY_OF_MONTH);
		int llHour = cal.get(Calendar.HOUR_OF_DAY);
		int llMinute = cal.get(Calendar.MINUTE);
		
		Calendar nowCal = Calendar.getInstance();
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		nowCal.setTime(stamp);
		System.out.println("Timestamp now " + stamp);
		
		int year = nowCal.get(Calendar.YEAR);
		int month = nowCal.get(Calendar.MONTH);
		int day = nowCal.get(Calendar.DAY_OF_MONTH);
		int hour = nowCal.get(Calendar.HOUR_OF_DAY);
		int minute = nowCal.get(Calendar.MINUTE);
		
		int yearDiff = year - llYear;
		int monthDiff = month - llMonth;
		int dayDiff = day - llDay;
		int hourDiff = hour - llHour;
		int minuteDiff = minute - llMinute;
		if(yearDiff > 0)		return yearDiff>1?   yearDiff + " years": yearDiff + " year";
		else if(monthDiff > 0)	return monthDiff>1?  monthDiff + " months": monthDiff + " month";
		else if(dayDiff > 0)	return dayDiff>1?    dayDiff + " days": dayDiff + " day";
		else if(hourDiff > 0) 	return hourDiff>1?   hourDiff + " hours": hourDiff + " hour";
		else 					return minuteDiff>1? minuteDiff + " minutes":minuteDiff + " minute";
	}
}
