package com.happylife;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.happylife.pojo.LookingFor;
import com.happylife.pojo.User;

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
		else if(minuteDiff > 5) return minuteDiff + " minutes";
		else return "Online";
	}
	
	public String constructQuery(User user, String query) {
		String column = "lookingin";
		boolean flag = false;
		switch (column) {
		case "lookingin":
			if(user.getLookingIn()!= null) {
				flag = true ;
				query = query + "(" +column + "='" + user.getLookingIn() + "' or " +column+ "='dontmind')";
			}
			column = "ethnicorigin";
		case "ethnicorigin":
			if(user.getEthnicOrigin()!= null && !user.getEthnicOrigin().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getEthnicOrigin() + "' or " +column+ "='dontmind')";
			}
			column = "bodytype";
		case "bodytype":
			if(user.getBodyType()!= null && !user.getBodyType().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getBodyType() + "' or " +column+ "='dontmind')";
			}
			column = "hijab_beard";
		case "hijab_beard":
			if(user.getHijabBeard()!= null && !user.getHijabBeard().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getHijabBeard() + "' or " +column+ "='dontmind')";
			}
			column = "pray";
		case "pray":
			if(user.getPray()!= null) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + ">='" + user.getPray() + "' or " +column+ "='dontmind')";
			}
			column = "sect";
		case "sect":
			if(user.getSect()!= null && !user.getSect().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getSect() + "' or " +column+ "='dontmind')";
			}
			column = "maritalstatus";
		case "maritalstatus":
			if(user.getMaritalStatus()!= null && !user.getMaritalStatus().equals("preferN")) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getMaritalStatus() + "' or " +column+ "='dontmind')";
			}
			column = "profession";
		case "profession":
			if(user.getProfession()!= null) {
				if(flag) query = query + " and "; else flag = true;
				query = query + "(" +column + "='" + user.getProfession() + "' or " +column+ "='dontmind'" + " or " +column+ "='Other')";
			}
			column = "AgeRange";
			/*
			 * case "AgeRange": for(LookingFor lf:agerange) { query = query + " and "; query
			 * = query + "'" +user.getAge(user.getDob())+ "'" + " between AgeL and AgeH "; }
			 * column = "HeightRange"; case "HeightRange": for(LookingFor lf:heightrange) {
			 * query = query + " and "; query = query + "'" +user.getHeight()+ "'" +
			 * " between HeightL and HeightH "; }
			 */
		}
		
		return query;
	}
	public String constructLookingForQuery(User user, String [][] agerange, String [][] heightrange) {
		String query = "select userId from looking_for where ";
		String column = "lookingin";
		switch (column) {
		case "lookingin":
			if(user.getLookingIn()!= null) {
				query = query + column + "='" + user.getLookingIn() + "' or " +column+ "='dontmind'";
			}
			column = "ethnicorigin";
		case "ethnicorigin":
			if(user.getEthnicOrigin()!= null && !user.getEthnicOrigin().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getEthnicOrigin() + "' or " +column+ "='dontmind'";
			}
			column = "bodytype";
		case "bodytype":
			if(user.getBodyType()!= null &&!user.getBodyType().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getBodyType() + "' or " +column+ "='dontmind'";
			}
			column = "hijab_beard";
		case "hijab_beard":
			if(user.getHijabBeard()!= null && !user.getHijabBeard().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getHijabBeard() + "' or " +column+ "='dontmind'";
			}
			column = "pray";
		case "pray":
			if(user.getPray()!= null) {
				query = query + " and ";
				query = query + column + "='" + user.getPray() + "' or " +column+ "='dontmind'";
			}
			column = "sect";
		case "sect":
			if(user.getSect()!= null && !user.getSect().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getSect() + "' or " +column+ "='dontmind'";
			}
			column = "maritalstatus";
		case "maritalstatus":
			if(user.getMaritalStatus()!= null && !user.getMaritalStatus().equals("preferN")) {
				query = query + " and ";
				query = query + column + "='" + user.getMaritalStatus() + "' or " +column+ "='dontmind'";
			}
			column = "profession";
		case "profession":
			if(user.getProfession()!= null) {
				query = query + " and ";
				query = query + column + "='" + user.getProfession() + "' or " +column+ "='dontmind'";
			}
			column = "AgeRange";
		case "AgeRange":
			for(int i=0; i<agerange[0].length; i++) {
				query = query + " and ";
				query = query +user.getAge(user.getDob())+ " between '" +agerange[0][i]+ "' and '" +agerange[1][i]+ "' ";
			}
			column = "HeightRange";
		case "HeightRange":
			for(int i=0; i<heightrange[0].length; i++) {
				query = query + " and ";
				query = query +user.getHeight()+ " between '" +heightrange[0][i]+ "' and '" +heightrange[1][i]+ "' ";
			}
		}
		
		return query;
	}
	
	
	public String constructQuery(List<Long> userIds, String matchGender) {
		int fl = 0;
		int i = 0;
		String query = "select * from hl_users where ";
		if(userIds.get(0) != null) {
			for(Long id:userIds) {
				fl = 1; if(fl == 1 && i != 0) query = query + " or ";
				query = query + "(userId='" + id + "' and gender='" + matchGender + "') ";
				i++;
			}
		}
		return query;
	}
}
