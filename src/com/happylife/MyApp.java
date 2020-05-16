package com.happylife;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import com.happylife.dao.implementation.MessageDAOImpl;
import com.happylife.dao.implementation.UserDAOImpl;
import com.happylife.dao.layer.MessageDAO;
import com.happylife.dao.layer.UserDAO;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;

public class MyApp {

	public static void main(String[] args) throws Exception {
		
		/*
		 * UserDAO userDAO = new UserDAOImpl(); List<User> list =
		 * userDAO.searchByLocation("F", args); Iterator<User> itr = list.iterator();
		 * while (itr.hasNext()){ User u = itr.next(); // why did you define this object
		 * inside the while loop; System.out.println(u.getUsername()); }
		 */
		
		/*
		 * DoMath doM = new DoMath(); String dateStr = "2011-06-12"; Timestamp ts =
		 * Timestamp.valueOf("2020-05-14 15:24:42"); Date date = Date.valueOf(dateStr);
		 * System.out.println("Date given by main is " + date); int age =
		 * doM.getAge(date); System.out.println("Age calulated by doMath is " + age);
		 * 
		 * Timestamp stamp = new Timestamp(System.currentTimeMillis());
		 * System.out.println("Timestamp in main " + stamp);
		 * System.out.println("Last Login " + doM.getLastLogin(ts));
		 */
		
		MessageDAO messageDao = new MessageDAOImpl();
		List<Messages> mlist = messageDao.getChat(8, 1);
		Iterator<Messages> itr = mlist.iterator();
		while (itr.hasNext()){
			Messages m = itr.next();
			System.out.println(m.getMessageId() + " " + m.getMsgContent());
		}
	}

}
