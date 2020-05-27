package com.happylife.controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happylife.DoMath;
import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.LookingFor;
import com.happylife.pojo.User;

@WebServlet("/candid")
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getQueryString();			// Extracting the candidate Id then look for user in the searchList gotten from Search Servlet
		if (request.getQueryString() != null) {
			System.out.println("Query String is: " + query);
			long candidId = Long.parseLong(query.substring(1));
			System.out.println("Candiate Id = " + candidId);
			//List<User> list = (List<User>) request.getAttribute("searchList");	// I couldn't get it, it is null		// Attribute was on Search Controller
			//if(list==null) System.out.println("List is Null");
			HttpSession session = request.getSession();
			try {
				User candidUser = RegistryDAO.getUserDAO().getUserByUserId(candidId);
				LookingFor lFor = RegistryDAO.getLookingForDAO().getLookingFor(candidId);
				DoMath doM = new DoMath();
				LookingFor candidlookingFor = RegistryDAO.getLookingForDAO().getLookingFor(candidUser.getUserId());
				System.out.println("Candidate User is: " + candidUser.getEmail());
				request.setAttribute("candidate", candidUser);
				request.setAttribute("candidLookingfor", lFor);
				request.setAttribute("CandidateLookingfor", candidlookingFor);
				String lastLogin = doM.getLastLogin(candidUser.getLastLogin());
				request.setAttribute("candidLastLogin", lastLogin);
				ServletContext ctx = getServletContext();
				ctx.setAttribute("candidate", candidUser);
			} catch (UserDAOException | LookingForDAOException e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/viewcandid.jsp");
		rd.forward(request, response);
	}
	
	

}
