package com.hl.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hl.pojo.User;

@Controller
public class MyProfileController{
	@RequestMapping(value="/myprofile" , method=RequestMethod.GET)
	public ModelAndView load_myprofile(HttpSession session){
		ModelAndView mav = new ModelAndView("myprofile");
		String userName = session.getAttribute("username").toString();
		User sessionUsr = (User) session.getAttribute("sessionUser");
		String image = sessionUsr.getImage();
		mav.addObject("username", userName);
		mav.addObject("usrImage", image);
		//mav.addObject("usr", sessionUsr); // not used yet
		
		return mav;
	}
	
	@RequestMapping(value="/howilook" , method=RequestMethod.GET)
	public ModelAndView loadHowILook(HttpSession session){
		ModelAndView mav = new ModelAndView("howilook");
		String userName = session.getAttribute("username").toString();
		
		mav.addObject("username", userName);
		
		return mav;
	}
}
