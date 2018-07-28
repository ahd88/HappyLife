package com.hl.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hl.pojo.User;

@Controller
public class ViewProfileController {
	
	@RequestMapping(value="/candid", method=RequestMethod.GET)
	public ModelAndView viewCandidateProfile(HttpServletRequest req, HttpSession session){
		ModelAndView mav = new ModelAndView("viewcandid");
		
		String userName = session.getAttribute("username").toString();
		User sessionUsr = (User) session.getAttribute("sessionUser");
		String image = sessionUsr.getImage();
		String pImage = sessionUsr.getPublicPhoto().toUpperCase();
		String candidUserId = req.getParameter("candidUid");
		mav.addObject("usrPublicPhoto", pImage);
		mav.addObject("usrImage", image);
		mav.addObject("username", userName);
		
		return mav;
	}
}
