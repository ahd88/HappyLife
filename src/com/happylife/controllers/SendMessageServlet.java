package com.happylife.controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happylife.dao.layer.MessageDAOException;
import com.happylife.dao.registry.RegistryDAO;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;

/**
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/sendmessage")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User candidate = (User) getServletContext().getAttribute("candidate");		// Attribute was set in ViewProfileServlet
		request.setAttribute("candidName", candidate.getUsername());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/sendmessage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Messages message = new Messages();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		User sessionUser = (User) request.getSession().getAttribute("sessionUser");
		User candidate = (User) getServletContext().getAttribute("candidate");		// Attribute was set in ViewProfileServlet
		System.out.println("Candidate username to send to is" + candidate.getUsername());
		String messageContent = request.getParameter("message");
		message.setSenderId(sessionUser.getId());
		message.setRecipientId(candidate.getId());
		message.setMessage(messageContent);
		message.setTime(timestamp);
		
		try {
			RegistryDAO.getMessageDAO().doSendMessage(message);
		} catch (MessageDAOException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
