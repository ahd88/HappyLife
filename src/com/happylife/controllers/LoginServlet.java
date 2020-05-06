package com.happylife.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;

import com.happylife.pojo.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//BindingResult br = null;
		//Model md = null;
		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println("Username and pasword are : "+email +"  "+ password);
		//if(br.getAllErrors().size() > 0){
			//System.out.println("Server side validation takes place....");	
		//}else{

			try {
				User userFetched = RegistryDAO.getUserDAO().doLogin(email, password);
				//User userFetched = RegistryDAO.getUserDAO().doHibernateLogin(email, password);
				
				if(userFetched != null){
					String aboutme = RegistryDAO.getUserDAO().getAboutMe(userFetched.getId());
					String lookingfor = RegistryDAO.getUserDAO().getLookingFor(userFetched.getId());
					session.setAttribute("sessionUser", userFetched);
					session.setAttribute("userId", userFetched.getId());
					session.setAttribute("username", userFetched.getUsername());
					session.setAttribute("aboutMeInfo", aboutme);
					session.setAttribute("lookingForInfo", lookingfor);
					
					session.setAttribute("personalPhoto", userFetched.getImage());
					session.setAttribute("publicPhoto", userFetched.getPublicPhoto()+".JPG");
					System.out.println("Fetched Personal photo name is "+ userFetched.getImage());
					System.out.println("Fetched Public photo name is "+ userFetched.getPublicPhoto());
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/myprofile.jsp");
					rd.forward(req, res);
					//res.sendRedirect("myprofile");
				}else{
					//md.addAttribute("error_msg", "please try again");
					req.setAttribute("error_msg", "please try again");
					RequestDispatcher rd = req.getRequestDispatcher("/login");
					rd.forward(req,res);
				}
			} catch (UserDAOException e) {
				e.printStackTrace();
				res.sendRedirect("login.html");
			}
			
		//}
	}
}
