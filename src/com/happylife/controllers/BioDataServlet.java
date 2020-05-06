package com.happylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.User;

/**
 * Servlet implementation class BioDataServlet 						*
 * It saves about_myself to the database							*
 * I am not able to use getAttribute in almost all cases			*
 * System.out.println("userId Attribute got from LoginServlet ...");*
 * render null 														*
 */
@WebServlet("/aboutme&lookingfor")
public class BioDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User sessionUsr = (User) session.getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		long id = (long)sessionUsr.getId();								// Attribute sessionUser set in LoginServlet
		
		try {
			String aboutme = RegistryDAO.getUserDAO().getAboutMe(id);
			String lookingfor = RegistryDAO.getUserDAO().getLookingFor(id);
			session.removeAttribute("aboutMeInfo");
			session.removeAttribute("lookingForInfo");
			
			session.setAttribute("aboutMeInfo", aboutme);
			session.setAttribute("lookingForInfo", lookingfor);
		} catch (UserDAOException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/aboutme.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User sessionUsr = (User) session.getAttribute("sessionUser");	// Attribute sessionUser set in LoginServlet
		String aboutme = request.getParameter("AboutMe");
		String lookingfor = request.getParameter("LookingFor");
		String aboutMeMessage = "";
		String lookingForMessage = "";
		
		try {
			aboutMeMessage = RegistryDAO.getUserDAO().UpdateAboutMe(sessionUsr, aboutme);
			lookingForMessage = RegistryDAO.getUserDAO().UpdateLookingFor(sessionUsr, lookingfor);
			System.out.println("Looking For updated Successfully...");
			
		}catch(UserDAOException e) {
			e.printStackTrace();
			System.out.println("About me Message in BioDataServlet is: " + aboutMeMessage);
			System.out.println("Looking for Message in BioDataServlet is: " + lookingForMessage);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pinfo.jsp");
		rd.forward(request, response);
	}

}
