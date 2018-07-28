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
	public ModelAndView loadSearchResults(HttpServletRequest req, HttpSession session){
		ModelAndView mav = new ModelAndView("searchresult");
		String desiredLocation = req.getParameter("country");
		String message = "";
		User sessionUsr = (User)session.getAttribute("sessionUser");
		String matchGender = "";
		if(sessionUsr.getGender().equals("M"))	matchGender = "F";
		else	matchGender = "M";
		
		System.out.println("matchGender is:" + matchGender);
		
		try {
			List<User> list = RegistryDAO.getUserDAO().searchByLocation(matchGender, desiredLocation);
			mav.addObject("searchList", list);
			for(User user: list){
				System.out.println(user.getUsername());
			}
		} catch (UserDAOException e) {
			message = e.getMessage();
			e.printStackTrace();
		}
		
		String lookingForInfo = sessionUsr.getLookingFor();
		
		String image = sessionUsr.getImage();
		String pImage = sessionUsr.getPublicPhoto().toUpperCase();
		
		mav.addObject("usrPublicPhoto", pImage);
		mav.addObject("usrImage", image);
		mav.addObject("LookingForInfo", lookingForInfo);
		
		mav.addObject(message);
		return mav;
	}
}
