package com.happylife.controllers;

import java.io.IOException;
import java.util.Random;

import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random rand = new Random();
		int n = rand.nextInt(16)+1;
		String message = "";
		String signupStatus = "";
		
		System.out.println("n = "+ n);
				
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String gender = request.getParameter("sex");
		String country = request.getParameter("country");
		String phone = request.getParameter("phone");
		
		//String image = new File(data.get(9).getName()).getName();
		
		User user = new User();
		user.setFname(firstName);
		user.setLname(lastName);
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setCountry(country);
		user.setPhone(phone);
		//user.setImage(image);
		
		System.out.println("First Name is " +firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(username);
		System.out.println(password);
		System.out.println("Gender is " + gender);
		System.out.println(country);
		System.out.println(phone);
		//System.out.println(image);
		
		if(password.equals(repassword)){
			String publicPhoto = n + ".JPG";
			user.setPublicPhoto(publicPhoto);
			System.out.println(publicPhoto);
			//String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//usrphotos//";
			//data.get(6).write(new File(path + File.separator + image));
			
			signupStatus = RegistryDAO.getUserDAO().doSignUp(user);
			//String signupStatus = RegistryDAO.getUserDAO().doHibernateSignUp(user);
			
			System.out.println(" this is status from doSignUp: " + signupStatus);
			
			
		}else{
			message = "Password does not match..please try again";
			request.setAttribute("errorMsg", message);
			
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request,response);
		}
		
		
		if(signupStatus.equals("Sign Up Successfully..."))	response.sendRedirect("login.html");
		else {
			request.setAttribute("errorMsg", message);
			response.sendRedirect("signup.jsp");
		}
	}
}
