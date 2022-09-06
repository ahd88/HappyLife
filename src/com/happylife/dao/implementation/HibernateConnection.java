package com.happylife.dao.implementation;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.happylife.pojo.User;

public class HibernateConnection {
	
	public static SessionFactory sessionFactory;
	
	public static SessionFactory doHibernateConnection(){
		Properties database = new Properties();
		database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		database.setProperty("hibernate.connection.username", "amgo85");
		database.setProperty("hibernate.connection.password", "1234");
		database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/spring");
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		database.setProperty("hibernate.show_sql", "true");
		database.setProperty("hibernate.hbm2ddl.auto", "update");
		
		
		Configuration cfg = new Configuration()
							.setProperties(database)
							.addPackage("com.happylife.pojo")
							.addAnnotatedClass(User.class);
		
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		
		return sessionFactory;
		
	}
}
