package com.happylife;

import java.util.Iterator;
import java.util.List;

import com.happylife.dao.implementation.UserDAOImpl;
import com.happylife.dao.layer.UserDAO;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.pojo.User;

public class MyApp {

	public static void main(String[] args) throws Exception {
		
		UserDAO userDAO = new UserDAOImpl();
		List<User> list = userDAO.searchByLocation("F", args);
		Iterator<User> itr = list.iterator();
		while (itr.hasNext()){
			User u = itr.next();			// why did you define this object inside the while loop;
			System.out.println(u.getUsername());
		}
	}

}
