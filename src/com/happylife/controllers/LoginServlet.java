package com.happylife.controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.happylife.DoMath;
import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.LookingFor;
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
					DoMath doM = new DoMath();
					LookingFor lookingFor = RegistryDAO.getLookingForDAO().getLookingFor(userFetched.getUserId());
					System.out.println(lookingFor.getLookingFor());
					
					session.setAttribute("sessionUser", userFetched);
					session.setAttribute("sessionLookingFor", lookingFor);
					session.setAttribute("userId", userFetched.getUserId());
					session.setAttribute("username", userFetched.getUsername());
					session.setAttribute("gender",  userFetched.getGender());
					
					session.setAttribute("personalPhoto", userFetched.getImage());
					session.setAttribute("publicPhoto", userFetched.getPublicPhoto()+".JPG");
					session.setAttribute("aboutMeInfo", userFetched.getAboutMe());
					session.setAttribute("lookingForInfo", userFetched.getLookingFor());
					session.setAttribute("myAge", doM.getAge(userFetched.getDob()));
					System.out.println("Fetched Personal photo name is "+ userFetched.getImage());
					System.out.println("Fetched Public photo name is "+ userFetched.getPublicPhoto());
					session.setAttribute("photopath", "F:/GitHub/HappyLife/WebContent/WEB-INF/usrphotos/"+userFetched.getImage());
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/myprofile.jsp");
					rd.forward(req, res);
					//res.sendRedirect("myprofile");
				}else{
					//md.addAttribute("error_msg", "please try again");
					req.setAttribute("error_msg", "please try again");
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					rd.forward(req,res);
				}
			} catch (UserDAOException | LookingForDAOException e) {
				e.printStackTrace();
				res.sendRedirect("login.html");
			}
			
		//}
	}
}
