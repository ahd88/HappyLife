package com.happylife.dao.layer;

import java.util.List;

import com.happylife.pojo.Messages;
import com.happylife.pojo.User;


public interface MessageDAO {
	public String doSendMessage(Messages message) throws MessageDAOException;
	//public String doSendMessageHibernate(Messages message) throws MessageDAOException;
	public List<Messages> getAllInboxMsgs(User user) throws MessageDAOException;
	//public List<Messages> doCheckInboxForUnReadMsgsHibernate(User user) throws MessageDAOException;
	public List<Messages> getChat(long userId, long candidId) throws MessageDAOException;
	//public String getChatHibernate(long userId, long candidId) throws MessageDAOException;
	public String updateMessageStatus(long candidId, long userId)throws MessageDAOException;
	//public String updateMessageStatusHibernate(long candidId)throws MessageDAOException;
}
