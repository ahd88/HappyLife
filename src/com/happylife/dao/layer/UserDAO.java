package com.happylife.dao.layer;

import java.util.List;

import com.happylife.pojo.User;

public interface UserDAO {
	public User doLogin(String email, String password) throws UserDAOException;
	public User doHibernateLogin(String email, String password) throws UserDAOException;
	public String doSignUp(User user);
	public String doHibernateSignUp(User user);
	public void updateUser(User user)throws UserDAOException;
	//public void updateUserHibernate(User user)throws UserDAOException;	//to be implemented
	public List<User> searchByLocation(String matchgender, String ...v)throws UserDAOException;
	//public List<User> searchByLocationHibernate(String matchgender, String ...v)throws UserDAOException;
	public User getUser(long id)throws UserDAOException;
	//public User getUserHibernate(long id)throws UserDAOException;
	public String UpdateAboutMe(User user, String aboutme)throws UserDAOException;
	//public String UpdateAboutMeHibernate(User user, String aboutme)throws UserDAOException;
	public String UpdateLookingFor(User user, String lookingfor)throws UserDAOException;
	//public String UpdateLookingForHibernate(User user, String lookingfor)throws UserDAOException;
	public String getAboutMe(long userId) throws UserDAOException;
	//public String getAboutMeHibernate(long userId) throws UserDAOException;
	public String getLookingFor(long userId) throws UserDAOException;
	//public String getLookingForHibernate(long userId) throws UserDAOException;
}
