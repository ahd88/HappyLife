package com.happylife.dao.registry;

import com.happylife.dao.implementation.MessageDAOImpl;
import com.happylife.dao.implementation.UserDAOImpl;
import com.happylife.dao.layer.MessageDAO;
import com.happylife.dao.layer.UserDAO;

public class RegistryDAO {
	public static UserDAO userDAO;
	public static MessageDAO messageDAO;
	
	static{
		userDAO = new UserDAOImpl();
	}

	public static UserDAO getUserDAO() {
		return userDAO;
	}
	
	public static void setUserDAO(UserDAO userDAO) {
		RegistryDAO.userDAO = userDAO;
	}
	
	static{
		messageDAO = new MessageDAOImpl();
	}

	public static MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public static void setMessageDAO(MessageDAO msgDAO) {
		RegistryDAO.messageDAO = msgDAO;
	}
}