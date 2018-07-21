package com.hl.dao.registry;

import com.hl.dao.implementation.UserDAOImpl;
import com.hl.dao.layer.UserDAO;

public class RegistryDAO {
	
	public static UserDAO userDAO;
	
	static{
		userDAO = new UserDAOImpl();
	}

	public static UserDAO getUserDAO() {
		return userDAO;
	}

	public static void setUserDAO(UserDAO userDAO) {
		RegistryDAO.userDAO = userDAO;
	}

}
