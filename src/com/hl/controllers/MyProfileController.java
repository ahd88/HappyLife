package com.hl.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hl.dao.layer.UserDAOException;
import com.hl.dao.registry.RegistryDAO;
import com.hl.pojo.User;

@Controller
public class MyProfileController{
	@RequestMapping(value="/myprofile" , method=RequestMethod.GET)
	public ModelAndView load_myprofile(HttpSession session){
		ModelAndView mav = new ModelAndView("myprofile");
		String userName = session.getAttribute("username").toString();
		User sessionUsr = (User) session.getAttribute("sessionUser");
		String image = sessionUsr.getImage();
		String pImage = sessionUsr.getPublicPhoto().toUpperCase();
		
		mav.addObject("usrPublicPhoto", pImage);
		mav.addObject("usrImage", image);
		mav.addObject("username", userName);
		
		//mav.addObject("usr", sessionUsr); // not used yet
		
		return mav;
	}
	
	@RequestMapping(value="/aboutme", method=RequestMethod.GET)
	public ModelAndView loadAboutMe(HttpSession session){
		ModelAndView mav = new ModelAndView("aboutme");
		String userName = session.getAttribute("username").toString();
		
		User sessionUsr = (User) session.getAttribute("sessionUser");
		
		String aboutMeInfo = sessionUsr.getAboutMe();
		
		String image = sessionUsr.getImage();
		String pImage = sessionUsr.getPublicPhoto().toUpperCase();
		
		mav.addObject("usrPublicPhoto", pImage);
		mav.addObject("usrImage", image);
		mav.addObject("AboutMeInfo", aboutMeInfo);
		
		mav.addObject("username", userName);
		return mav;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/aboutmesaved", method=RequestMethod.POST)
	public ModelAndView saveAboutMe(HttpServletRequest req, HttpSession session){
		ModelAndView mav = new ModelAndView("aboutme");
		String userName = session.getAttribute("username").toString();
		String aboutMe = req.getParameter("AboutMe");
		User sessionUsr = (User) session.getAttribute("sessionUser");
		sessionUsr.setAboutMe(aboutMe);
		
		try {
			RegistryDAO.getUserDAO().updateUser(sessionUsr);
		} catch (UserDAOException e) {
			e.printStackTrace();
		}
		
		String image = sessionUsr.getImage();
		String pImage = sessionUsr.getPublicPhoto().toUpperCase();
		
		mav.addObject("usrPublicPhoto", pImage);
		mav.addObject("usrImage", image);
		
		mav.addObject("username", userName);
		return mav;
	}
	
	
	@RequestMapping(value="/lookingfor", method=RequestMethod.GET)
	public ModelAndView loadLookingFor(HttpSession session){
		ModelAndView mav = new ModelAndView("lookingfor");
		String userName = session.getAttribute("username").toString();
		
		User sessionUsr = (User) session.getAttribute("sessionUser");
		
		String lookingForInfo = sessionUsr.getLookingFor();
		
		String image = sessionUsr.getImage();
		String pImage = sessionUsr.getPublicPhoto().toUpperCase();
		
		mav.addObject("usrPublicPhoto", pImage);
		mav.addObject("usrImage", image);
		mav.addObject("LookingForInfo", lookingForInfo);
		
		mav.addObject("username", userName);
		return mav;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/lookingforsaved", method=RequestMethod.POST)
	public ModelAndView saveLookingFor(HttpServletRequest req, HttpSession session){
		ModelAndView mav = new ModelAndView("lookingfor");
		String userName = session.getAttribute("username").toString();
		String lookingFor = req.getParameter("LookingFor");
		User sessionUsr = (User) session.getAttribute("sessionUser");
		sessionUsr.setLookingFor(lookingFor);
		
		try {
			RegistryDAO.getUserDAO().updateUser(sessionUsr);
		} catch (UserDAOException e) {
			e.printStackTrace();
		}
		
		String image = sessionUsr.getImage();
		String pImage = sessionUsr.getPublicPhoto().toUpperCase();
		
		mav.addObject("usrPublicPhoto", pImage);
		mav.addObject("usrImage", image);
		
		mav.addObject("username", userName);
		return mav;
	}
	
	@RequestMapping(value="/#howilook" , method=RequestMethod.GET)
	public ModelAndView loadHowILook(HttpSession session){
		ModelAndView mav = new ModelAndView("howilook");
		String userName = session.getAttribute("username").toString();
		
		User sessionUsr = (User) session.getAttribute("sessionUser");
		String pImage = sessionUsr.getPublicPhoto();
		
		mav.addObject("usrPublicPhoto", pImage);
		mav.addObject("username", userName);
		
		return mav;
	}
}
