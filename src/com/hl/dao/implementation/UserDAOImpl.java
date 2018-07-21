package com.hl.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hl.dao.layer.UserDAO;
import com.hl.dao.layer.UserDAOException;
import com.hl.pojo.User;

public class UserDAOImpl  implements UserDAO{
	public User doHibernateLogin(String email, String password) throws UserDAOException{
		
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
		Session session = sessionFactory.openSession();
		try{	
			session.beginTransaction();
			List<User> user = session.createQuery("From User where email='"+email+"' and password='"+password+"'").list();
			
			if(user.size() == 1) return user.get(0);
			else throw new UserDAOException("user not found") ;
			
		}catch(Exception e){
			throw new UserDAOException(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public String doHibernateSignUp(User user){
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
		Session session = sessionFactory.openSession();
		try{
			System.out.println("Inside doHibernateSignUp");
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return "Sign Up Successfully...";
			
		}catch(Exception e){
			e.printStackTrace();
			return "User is already there with this username";
		}finally{
			session.close();
		}
	}
	
	public List<User> searchByLocation(String matchGender, String ...v) throws UserDAOException{
		Session session = HibernateConnection.doHibernateConnection().openSession();
		session.beginTransaction();
		
		//for(String x:v)
		try{
			List<User> searchList = session.createQuery("From User where gender ='"+matchGender+"' and country='"+v[0]+"'").list();
			
			if(searchList == null) throw new UserDAOException("You Search Criteria is not met") ;
			else return searchList;
		}catch(Exception e){
			throw new UserDAOException(e.getMessage());
		}finally{
			session.close();
		}
	}
}
