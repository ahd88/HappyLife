package com.hl.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hl.dao.registry.RegistryDAO;
import com.hl.pojo.User;
import java.util.Random;

@Controller
@MultipartConfig
public class SignUpController {
	@RequestMapping(value="/signup" , method=RequestMethod.GET)
	public ModelAndView loadSignUpPage(HttpServletRequest req){
		ModelAndView mav = new ModelAndView("signup");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String gender = req.getParameter("sex");
		req.setAttribute("firstName", fname);
		req.setAttribute("lastName", lname);
		req.setAttribute("email", email);
		req.setAttribute("gender", gender);
		System.out.println("the first name is: " + fname);
		return mav;
	}
	
	@RequestMapping(value="/signup" , method=RequestMethod.POST)
	public String doSignUpProcess(HttpServletRequest request, Model md){
		//ModelAndView mav = new ModelAndView("signup");
		Random rand = new Random();
		int n = rand.nextInt(16)+1;
		String message = "";
		
		System.out.println("n = "+ n);
		if(ServletFileUpload.isMultipartContent(request)){
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				String firstName = data.get(0).getString();
				String lastName = data.get(1).getString();
				String email = data.get(2).getString();
				String username = data.get(3).getString();
				String password = data.get(6).getString();
				String repassword = data.get(5).getString();
				String gender = data.get(7).getString();
				String country = data.get(4).getString();
				String phone = data.get(8).getString();
				
				String image = new File(data.get(9).getName()).getName();
				
				User user = new User();
				user.setFname(firstName);
				user.setLname(lastName);
				user.setEmail(email);
				user.setUsername(username);
				user.setPassword(password);
				user.setGender(gender);
				user.setCountry(country);
				user.setPhone(phone);
				user.setImage(image);
				
				System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(email);
				System.out.println(username);
				System.out.println(password);
				System.out.println(gender);
				System.out.println(country);
				System.out.println(phone);
				System.out.println(image);
				
				if(password.equals(repassword)){
					String publicPhoto = n + ".jpg";
					user.setPublicPhoto(publicPhoto);
					System.out.println(publicPhoto);
					String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//usrphotos//";
					data.get(6).write(new File(path + File.separator + image));
					
					String msg = RegistryDAO.getUserDAO().doHibernateSignUp(user);
					
					System.out.println(msg);
					return "login";
				}else{
					message = "Password does not match..please try again";
					
					return "signup";
				}
				
			}catch(Exception e){
				System.out.println(e);
				message = "Please try again....";
			}
		} // if(multipart)
		
		md.addAttribute("error_msg", message);
		return "signup";
	}
	
	@RequestMapping(value="/dynamic/{message}" , method=RequestMethod.GET)
	public ModelAndView dynamicDemo(@PathVariable("message") String message)
	{
		ModelAndView mav = new ModelAndView("signup");
		System.out.println(message);
		return mav;
	}
}