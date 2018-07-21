package com.hl.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hl.dao.registry.RegistryDAO;
import com.hl.pojo.User;

@Controller
public class LoginController {

	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public ModelAndView loadLoginPage(){
		ModelAndView mav = new ModelAndView("login");
		System.out.println("Login method has been called");
		
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String do_login(HttpServletRequest req , Model md , HttpSession session , @Valid User user, BindingResult br){
		try{
			//System.out.println(br.getAllErrors().size());
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			System.out.println("Username and pasword are : "+email +"  "+ password);
			if(br.getAllErrors().size() > 0){
				System.out.println("Server side validation takes place....");	
			}else{
				//Login_Model lm = new Login_Model();
				//String message = lm.do_login_process(username, password);
				
				User sessionUser = RegistryDAO.getUserDAO().doHibernateLogin(email, password);
				session.setAttribute("sessionUser", sessionUser);
				if(sessionUser != null){
					session.setAttribute("username", sessionUser.getUsername());
					return "redirect:/myprofile";
				}else{
					md.addAttribute("error_msg", "please try again");
				}
			}
			return "login";
		} catch(Exception e){
			return "login";
		}
	}
	
}
