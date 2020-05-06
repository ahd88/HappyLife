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

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String desiredLocation = req.getParameter("country");
		User sessionUser = (User) req.getSession().getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		String matchGender = "";
		String message = "";
		if(sessionUser.getGender().equals("M"))	matchGender = "F";
		else	matchGender = "M";
		System.out.println("matchGender is:" + matchGender);
		
		try {
			List<User> list = RegistryDAO.getUserDAO().searchByLocation(matchGender, desiredLocation);
			req.setAttribute("searchList", list);
			for(User user: list){
				System.out.println(user.getUsername());
			}
			req.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, res);
			
			//res.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (UserDAOException e) {
			e.printStackTrace();
			if(e.getMessage().equals("You Search Criteria is not met")) message = "You Search Criteria is not met";
			req.setAttribute("noresult", message);
			
		}
		
	}

}
