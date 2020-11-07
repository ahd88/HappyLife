package com.happylife.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.util.PortalUtil;

public class PostLoginAction extends Action{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		long userId = PortalUtil.getUserId(request);
        LiveUsers.addUser(userId);
	}
	
}
