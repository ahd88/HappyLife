package com.happylife.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.User;
/*
 * the main three search criteria are:
 * (1) whom I am looking for:
 * (2) who look for:
 * (3) Ideal match:
 * */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String query = req.getQueryString();			//
		
		boolean isIdealcb = false;
		boolean isIlookfcb = false;
		boolean isLookformecb = false;
		boolean isOnline = false;
		boolean isPhotoupl = false;
		boolean isNotviewed = false;
		boolean isNotmsged = false;
		
		if(query != null) { 
			System.out.println("Query String in SearchServlet is: " + query);
			
			isIdealcb = query.indexOf("idealcb")!= -1?true:false;
			System.out.println("does Query contain idealcb? " + isIdealcb);
			isIlookfcb = query.indexOf("ilookfcb")!= -1?true:false;
			System.out.println("does Query contain ilookfcb? " + isIlookfcb);
			isLookformecb = query.indexOf("lookformecb")!= -1?true:false;
			System.out.println("does Query contain lookformecb? " + isLookformecb);
			isOnline = query.indexOf("online")!= -1?true:false;
			System.out.println("does Query contain online? " + isOnline);
			isPhotoupl = query.indexOf("photoupl")!= -1?true:false;
			System.out.println("does Query contain photoupl? " + isPhotoupl);
			isNotviewed = query.indexOf("notviewed")!= -1?true:false;
			System.out.println("does Query contain notviewed? " + isNotviewed);
			isNotmsged = query.indexOf("notmsged")!= -1?true:false;
			System.out.println("does Query contain notmsged? " + isNotmsged);
		}
		String desiredLocation = req.getParameter("country");
		String agel = req.getParameter("agel");
		String ageh = req.getParameter("ageh");
		User sessionUser = (User) req.getSession().getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		String matchGender = "";
		String message = "";
		if(sessionUser.getGender().equals("M"))	matchGender = "F";
		else	matchGender = "M";
		System.out.println("matchGender is:" + matchGender);
		
		try {
			if(isIdealcb) {
				List<User> list = RegistryDAO.getUserDAO().searchBy(sessionUser, "idealcb", "true");
				req.setAttribute("searchList", list);
				for(User user: list){
					System.out.println(user.getUsername());
				}
				//req.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, res);
			}else if(isIlookfcb & !isLookformecb) {
				List<User> list = RegistryDAO.getUserDAO().searchBy(sessionUser, "ilookfcb", "true");
				req.setAttribute("searchList", list);
				for(User user: list){
					System.out.println(user.getUsername());
				}
				//req.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, res);
			} else if(isLookformecb & ! isIlookfcb) {
				System.out.println("Inside isLookformecb ");
				/*
				 * List<User> list = RegistryDAO.getUserDAO().searchBy(sessionUser,
				 * "lookformecb", "true", "isOnline", Boolean.toString(isOnline), "isPhotoupl",
				 * Boolean.toString(isPhotoupl), "isNotviewed", Boolean.toString(isNotviewed));
				 */
				List<User> list = RegistryDAO.getUserDAO().searchBy(sessionUser, "lookformecb", "true");
				req.setAttribute("searchList", list);
				for(User user: list){
					System.out.println(user.getUsername());
				}
				//req.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, res);
			} else if(desiredLocation != null) {
				
				List<User> list = RegistryDAO.getUserDAO().searchBy(sessionUser, "location", desiredLocation, "agel", agel, "ageh", ageh);
				
				req.setAttribute("searchList", list);
				for(User user: list){
					System.out.println(user.getUsername());
				}
			}else {
				List<User> list = RegistryDAO.getUserDAO().searchBy(sessionUser, "location", desiredLocation);
				req.setAttribute("searchList", list);
				for(User user: list){
					System.out.println(user.getUsername());
				}
			}
			req.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, res);
		} catch (UserDAOException e) {
			e.printStackTrace();
			if(e.getMessage().equals("You Search Criteria is not met")) message = "You Search Criteria is not met";
			req.setAttribute("noresult", message);
			
		}
		
	}

}
