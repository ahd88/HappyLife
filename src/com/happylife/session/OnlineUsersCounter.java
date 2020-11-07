package com.happylife.session;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.codahale.metrics.Counter;

public class OnlineUsersCounter implements HttpSessionListener {
	private static List<String> sessions = new ArrayList<>();
    private final Counter counterOfActiveSessions = MetricRegistrySingleton.metrics.counter("web.sessions.active.count");
    
    
    public OnlineUsersCounter() {
        super();
    }
    
	@Override
	public void sessionCreated(final HttpSessionEvent event) {
		System.out.println("SessionCounter.sessionCreated");
        HttpSession session = event.getSession();
        sessions.add(session.getId());
        
        counterOfActiveSessions.inc();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("SessionCounter.sessionDestroyed");
        HttpSession session = event.getSession();
        sessions.remove(session.getId());
        
        counterOfActiveSessions.dec();
	}
	
	
	
	public static int getActiveSessionNumber() {
        return sessions.size();
    }
}
