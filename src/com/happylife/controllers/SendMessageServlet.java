package com.happylife.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happylife.dao.layer.MessageDAOException;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;

/**
 * Servlet implementation class SendMessageServlet
 * the candidate attribute was used much in viewcandid page
 */
@WebServlet("/sendmessageto")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getQueryString();
		System.out.println("Query String in SendMessageServlet doGet is: " + query);
		if (request.getQueryString() != null) {
			long candidId = Long.parseLong(query.substring(1));
			System.out.println("Candidate Id in SendMessageServlet doGet = " + candidId);
			
			User sessionUser = (User)request.getSession().getAttribute("sessionUser");
			System.out.println("Session User name in SendMessageServlet = " + sessionUser.getUsername());
			try {
				
				User candidate = RegistryDAO.getUserDAO().getUser(candidId);
				System.out.println("Candiate Id in SendMessageServlet fetched from database = " + candidate.getId());
				request.setAttribute("candidName", candidate.getUsername());
				request.setAttribute("candidId", candidate.getId());
				System.out.println("Candidate name in SendMessageServlet is " + candidate.getUsername());
				List<Messages> mlist = RegistryDAO.getMessageDAO().getChat(sessionUser.getId(), candidate.getId());
				List<User> chatList = new ArrayList<User>();
				for(Messages m: mlist){
					User u = RegistryDAO.getUserDAO().getUser(m.getSenderId());
					System.out.println("Message " + m.getMessageId() + " is " + m.getMsgContent());
					chatList.add(u);
				}
				request.setAttribute("mlist", mlist);
				request.setAttribute("chatList", chatList);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/sendmessage.jsp");
				rd.forward(request, response);
			} catch (MessageDAOException | UserDAOException e) {
				
				e.printStackTrace();
			}
			
		}else System.out.println("query in SendMessageServlet is Null");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getQueryString();
		System.out.println("Query String in SendMessageServlet in doPost is: " + query);
		if (request.getQueryString() != null) {
			long candidId = Long.parseLong(query.substring(1));
			System.out.println("Candidate Id in SendMessageServlet doPost = " + candidId);
			
			Messages message = new Messages();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			User sessionUser = (User) request.getSession().getAttribute("sessionUser");
			//User candidate = (User) request.getServletContext().getAttribute("candidate");		// Attribute was set in ViewProfileServlet
			//System.out.println("Candidate username to send to is " + candidate.getUsername());
			String messageContent = request.getParameter("message");
			message.setSenderId(sessionUser.getId());
			message.setRecipientId(candidId);
			message.setMsgContent(messageContent);
			message.setTime(timestamp);
			
			try {
				RegistryDAO.getMessageDAO().doSendMessage(message);
			} catch (MessageDAOException e) {
				e.printStackTrace();
			}
			doGet(request, response);
		}else	System.out.println("Candidate Id got from SendMessageServlet doPost query String is null");
		
	}

}
