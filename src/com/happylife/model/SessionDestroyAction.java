package com.happylife.model;

import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SessionAction;
import com.liferay.portal.kernel.util.WebKeys;

public class SessionDestroyAction extends SessionAction{

	@Override
	public void run(HttpSession session) throws ActionException {
		Long userId = (Long) session.getAttribute(WebKeys.USER_ID);
        LiveUsers.removeUser(userId);
	}

}
