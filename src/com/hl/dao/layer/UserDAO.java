package com.hl.dao.layer;

import java.util.List;

import com.hl.pojo.User;

public interface UserDAO {
	public User doHibernateLogin(String email, String password) throws UserDAOException;
	public String doHibernateSignUp(User user);
	public List<User> searchByLocation(String matchgender, String ...v)throws UserDAOException;
}
