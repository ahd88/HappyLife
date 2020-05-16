package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.happylife.dao.layer.UserDAO;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;

public class UserDAOImpl implements UserDAO {
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	@Override
	public User doLogin(String email, String password) throws UserDAOException {
		User userToFetch = null;
		
		try{
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from HL_USERS where EMAIL=? and PASSWD=?"); 
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			rs = pstmt.executeQuery();
			
			//ResultSet rs = statement.executeQuery("select * from HL_USERS where EMAIL='"+email+"' and PASSWD='"+password+"'");
			System.out.println("select count(*) from HL_USERS where EMAIL='"+email+"' and PASSWD='"+password+"'");
			int columnCount = 0;
			while(rs.next()){
				for (int i = 1; i <= columnCount; i++ ) {
					  String name = rs.getMetaData().getColumnName(i);
					  System.out.println("Column name: "+ name);
					}
				long userId  = rs.getLong(1);					//rs.getLong("userId");
				String fname  = rs.getString(2);				//rs.getString("FNAME");
				String lname = rs.getString(3);					//rs.getString("LNAME");
				String emailId  = rs.getString(4);				//rs.getString("EMAIL");
				String uname  = rs.getString(5);				//rs.getString("username");
				String pass  = rs.getString(6);					//rs.getString("PASSWD");
				String gender  = rs.getString(7);				//rs.getString("GENDER");
				String country  = rs.getString(8);				//rs.getString("COUNTRY");
				String phone  = rs.getString(9);				//rs.getString("PHONE");
				String image  = rs.getString(10);				//rs.getString("IMAGE");
				Date dob = rs.getDate(11);
				String aboutMyself = rs.getString(14);
				String lookingFor = rs.getString(15);
				String publicPhoto  = rs.getString(16);			//rs.getString("PUBLIC_PHOTO");
				Timestamp lastLogin = rs.getTimestamp(17);
				User user = new User(userId, fname, lname, emailId, uname, gender, country, phone, image, dob, 
						aboutMyself, lookingFor, publicPhoto, lastLogin);
				userToFetch = user;
			}
			
			java.util.Date date = new java.util.Date();
			long time = date.getTime();
			Timestamp ts = new Timestamp(time);
			System.out.println("Timestamp after login is " + ts);
			pstmt = conn.prepareStatement("update HL_USERS set lastlogin=? where userId=?");
			pstmt.setLong(2,userToFetch.getId());
			pstmt.setTimestamp(1,ts);
			pstmt.executeUpdate();
			
			
			if(userToFetch == null){
				throw new UserDAOException("User not found");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return userToFetch;
	}
	
	
	
	@Override
	public String doSignUp(User user) {
		boolean status = false;
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("insert into HL_USERS values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			
			pstmt.setLong(1,user.getId());
			pstmt.setString(2,user.getFname());
			pstmt.setString(3,user.getLname());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getUsername());
			pstmt.setString(6,user.getPassword());
			pstmt.setString(7,user.getGender());
			pstmt.setString(8,user.getCountry());
			pstmt.setString(9,user.getPhone());
			pstmt.setString(10,null);
			pstmt.setDate(11,user.getDob());
			pstmt.setString(12,null);
			pstmt.setString(13,null);
			pstmt.setString(14,null);
			pstmt.setString(15,null);
			pstmt.setString(16,user.getPublicPhoto());
			pstmt.setTimestamp(17,null);
			status = pstmt.execute();
			
			//statment.executeQuery("INSERT INTO 'spring'.'HL_USERS' ('userId', 'FNAME', 'LNAME', 'EMAIL', 'USERNAME', 'PASSWD', 'GENDER', 'COUNTRY', 'PHONE', 'PUBLIC_PHOTO') VALUES ('"+user.getId()+"', '"+user.getFname()+"', '"+user.getLname()+"', '"+user.getEmail()+"', '"+user.getUsername()+"', '"+user.getPassword()+"', '"+user.getGender()+"', '"+user.getCountry()+"', '"+user.getPhone()+"', '"+user.getPublicPhoto()+"')");
			
			return "Sign Up Successfully...";
		}catch(SQLException e) {
			System.out.println(e);
			return "Something went wrong please try again ! ! !";
		}
	}

	@Override
	public void updateUser(User user) throws UserDAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> searchByLocation(String matchgender, String... v) throws UserDAOException {
		List<User> candidateList = new ArrayList<User>();
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from HL_USERS where gender=? and country=?");
			pstmt.setString(1,matchgender);
			pstmt.setString(2,v[0]);
			
			rs = pstmt.executeQuery();
			System.out.println("select count(*) from HL_USERS where gender='"+matchgender+"' and country='"+v[0]+"'");
			
			
			while (rs.next()){
				long userId  = rs.getLong(1);					
				String fname  = rs.getString(2);				
				String lname = rs.getString(3);					
				String emailId  = rs.getString(4);				
				String uname  = rs.getString(5);				
				String pass  = rs.getString(6);			// not taken		
				String gender  = rs.getString(7);				
				String country  = rs.getString(8);				
				String phone  = rs.getString(9);				
				String image  = rs.getString(10);	
				Date dob = rs.getDate(11);
				String aboutMyself = rs.getString(14);
				String lookingFor = rs.getString(15);
				String publicPhoto = rs.getString(16);
				Timestamp lastLogin = rs.getTimestamp(17);
				User candidate = new User(userId, fname, lname, emailId, uname, gender, country, phone, image, dob, aboutMyself, lookingFor, publicPhoto, lastLogin);
				candidateList.add(candidate);
			}
			if(candidateList == null) throw new UserDAOException("You Search Criteria is not met") ;
		}catch(Exception e) {
			e.printStackTrace();
			throw new UserDAOException(e.getMessage());
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		
		return candidateList;
	}
	
	@Override
	public User getUser(long id) throws UserDAOException {
		User candidate = null;
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from HL_USERS where userId=?");
			pstmt.setLong(1,id);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				long userId  = rs.getLong(1);					
				String fname  = rs.getString(2);				
				String lname = rs.getString(3);					
				String emailId  = rs.getString(4);				
				String uname  = rs.getString(5);				
				String pass  = rs.getString(6);					// not needed
				String gender  = rs.getString(7);				
				String country  = rs.getString(8);				
				String phone  = rs.getString(9);				
				String image  = rs.getString(10);				// I should take because I don't need it
				Date dob  = rs.getDate(11);
				String aboutMe = rs.getString(14);
				String lookingfor = rs.getString(15);
				String publicPhoto  = rs.getString(16);
				Timestamp lastLogin = rs.getTimestamp(17);
				candidate = new User(userId, fname, lname, emailId, uname, gender, country, phone, image, dob, aboutMe, lookingfor, publicPhoto, lastLogin);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return candidate;
	}
	
	@Override
	public String UpdateAboutMe(User user, String aboutme) throws UserDAOException {
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("update HL_USERS set about_myself=? where userId=?");
			pstmt.setLong(2,user.getId());
			pstmt.setString(1,aboutme);
			pstmt.executeUpdate();
			
			return "About Myself updated Successfully...";
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}
	
	@Override
	public String getAboutMe(long userId) throws UserDAOException {
		String aboutmefetched = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select about_myself from HL_USERS where userId=?");
			pstmt.setLong(1,userId);
			rs = pstmt.executeQuery();			// you have to write code for not creating more than one user with same emailid
			while (rs.next()){
				aboutmefetched  = rs.getString(1);
			}
			
			System.out.println("About me from IMPL is " + aboutmefetched);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return aboutmefetched;
	}

	@Override
	public String getLookingFor(long userId) throws UserDAOException {
		String lookingforfetched = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select looking_for from HL_USERS where userId=?");
			pstmt.setLong(1,userId);
			rs = pstmt.executeQuery();
			while (rs.next()){
				lookingforfetched  = rs.getString(1);
			}
			System.out.println("Looking For from IMPL is " + lookingforfetched);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return lookingforfetched;
	}

	@Override
	public String UpdateLookingFor(User user, String lookingfor) throws UserDAOException {
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("update HL_USERS set looking_for=? where userId=?");
			pstmt.setLong(2,user.getId());
			pstmt.setString(1,lookingfor);
			pstmt.executeUpdate();
			
			return "Looking For updated Successfully...";
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}
	
	
	
	/*
	 * @Override public void setLoginTime(long userId, Timestamp ts) throws
	 * UserDAOException { try { conn = DatabaseConnectivity.doDBConnection(); pstmt
	 * = conn.prepareStatement("update HL_USERS set lastlogin=? where userId=?");
	 * pstmt.setLong(2,userId); pstmt.setTimestamp(1,ts); pstmt.executeUpdate();
	 * 
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }finally { try { if(conn != null)
	 * conn.close(); if(pstmt != null) pstmt.close(); if(rs != null) rs.close(); }
	 * catch(Exception e){} } }
	 */
	
	@Override
	public User doHibernateLogin(String email, String password) throws UserDAOException {
		// TODO Auto-generated method stub
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

	@Override
	public String doHibernateSignUp(User user) {
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

}
