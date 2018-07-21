package com.hl.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hl.dao.layer.UserDAOException;
import com.hl.dao.registry.RegistryDAO;
import com.hl.pojo.User;

@Controller
public class SearchController {
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView loadSearchPage(HttpServletRequest req, HttpSession session){
		ModelAndView mav = new ModelAndView("myprofile");
		String desiredLocation = req.getParameter("country");
		String message = "";
		User sessionUsr = (User)session.getAttribute("session_user");
		String matchGender = "";
		if(sessionUsr.getGender().equals("M"))	matchGender = "F";
		else	matchGender = "F";
		try {
			List<User> list = RegistryDAO.getUserDAO().searchByLocation(matchGender, desiredLocation);
			for(User user: list){
				System.out.println(user.getUsername());
			}
		} catch (UserDAOException e) {
			message = e.getMessage();
			e.printStackTrace();
		}
		mav.addObject(message);
		return mav;
	}
}
