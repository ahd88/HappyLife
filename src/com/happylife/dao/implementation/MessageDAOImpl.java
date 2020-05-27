package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.happylife.dao.layer.MessageDAO;
import com.happylife.dao.layer.MessageDAOException;
import com.happylife.dao.layer.UserDAO;
import com.happylife.dao.layer.UserDAOException;
import com.happylife.pojo.Messages;
import com.happylife.pojo.User;

public class MessageDAOImpl implements MessageDAO{
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;

	@Override
	public String doSendMessage(Messages message) throws MessageDAOException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
		
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into messages values (?,?,?,?,?,?)" ); 
			pstmt.setLong(1,message.getMessageId());
			pstmt.setLong(2,message.getSenderId());
			pstmt.setLong(3,message.getRecipientId());
			pstmt.setString(4,message.getMsgContent());
			pstmt.setTimestamp(5, timestamp);
			
			pstmt.setBoolean(6,false);
			boolean status = pstmt.execute();
			
			return "Message sent Successfully...";
			
		}catch(Exception e) {
			System.out.println(e);
			return "Something went wrong please try again ! ! !";
		}
	}

	@Override
	public List<Messages> getAllInboxMsgs(User user) throws MessageDAOException {
		List<Messages> messagesList = new ArrayList<Messages>();
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from messages where recipientId=?");
			pstmt.setLong(1,user.getUserId());
			rs = pstmt.executeQuery();
			while (rs.next()){
				long msgId = rs.getLong(1);
				long sender = rs.getLong(2);
				long recipient = rs.getLong(3);
				String msg = rs.getString(4);
				Timestamp ts = rs.getTimestamp(5);
				boolean b = rs.getBoolean(6);
				Messages m = new Messages(msgId, sender, recipient, msg, ts, b);
				messagesList.add(m);
			}
			// counting unread messages
			int count = 0;
			for (Messages m:messagesList) {
				System.out.println("In getAllInbox Message" + m.getMessageId() + "to " +m.getRecipientId()+ " is " + m.getMsgContent());
				if(!m.getMessageStatus()) {
					count++;
				}
			}
			
			System.out.println("Number of unread messages = " + count);
			
			if(messagesList == null) throw new MessageDAOException("Your inbox is empty") ;
		}catch(Exception e) {
			e.printStackTrace();
			throw new MessageDAOException(e.getMessage());
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return messagesList;
	}

	@Override
	public List<Messages> getChat(long userId, long candidId) throws MessageDAOException {
		List<Messages> chatList = new ArrayList<Messages>();
		try {
			conn = DatabaseConnectivity.doDBConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from Messages where (senderId=? and recipientId=?) or (senderId=? and recipientId=?)");
			pstmt.setLong(1,candidId);
			pstmt.setLong(2,userId);
			pstmt.setLong(3,userId);
			pstmt.setLong(4,candidId);
			rs = pstmt.executeQuery();
			while (rs.next()){
				long msgId  = rs.getLong(1);
				long senderId  = rs.getLong(2);					
				long recipientId  = rs.getLong(3);
				String msgContent  = rs.getString(4);					
				Timestamp msgTime = rs.getTimestamp(5);
				boolean msgRead = rs.getBoolean(6);
				Messages msg = new Messages(msgId, senderId, recipientId, msgContent, msgTime, msgRead);
				chatList.add(msg);
			}
			for(Messages m: chatList){
				System.out.println("Message from getChat" + m.getMessageId() + " is " + m.getMsgContent());
			}
			if(chatList == null) throw new MessageDAOException("You have no messages with " + candidId);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return chatList;
	}

	@Override
	public String updateMessageStatus(long candidId, long userId) throws MessageDAOException {
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("update messages set msgRead=? where senderId=? and recipientId=?");
			pstmt.setBoolean(1,true);
			pstmt.setLong(2,candidId);
			pstmt.setLong(3,userId);
			pstmt.executeUpdate();
			
			return "Message Status updated Successfully...";
		}catch(Exception e) {
			e.printStackTrace();
			return "Something went wrong in upadating Message Status, please try again ! ! !";
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
	}
}
