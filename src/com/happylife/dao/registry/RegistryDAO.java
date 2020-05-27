package com.happylife.dao.registry;

import com.happylife.dao.implementation.LookingForDAOImpl;
import com.happylife.dao.implementation.MessageDAOImpl;
import com.happylife.dao.implementation.UserDAOImpl;
import com.happylife.dao.layer.LookingForDAO;
import com.happylife.dao.layer.MessageDAO;
import com.happylife.dao.layer.UserDAO;
import com.happylife.pojo.LookingFor;

public class RegistryDAO {
	public static UserDAO userDAO;
	public static MessageDAO messageDAO;
	public static LookingForDAO lookingForDAO;
	
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
	
	static {
		lookingForDAO = new LookingForDAOImpl();
	}
	
	public static LookingForDAO getLookingForDAO() {
		return lookingForDAO;
	}
	
	public static void setLookingForDAO(LookingForDAO lookingForDao) {
		RegistryDAO.lookingForDAO = lookingForDao;
	}
}