package com.happylife.model;

import java.util.ArrayList;
import java.util.List;

public class LiveUsers {
	private static List<Long> onlineUsers = new ArrayList<Long>();
	
	public static void addUser(long userId) {
		onlineUsers.add(userId);
    }

    public static void clearUsers() {
    	onlineUsers.clear();
    }

    public static void removeUser(long userId) {
    	onlineUsers.remove(userId);
    }

    public static int countUsers() {
        return onlineUsers.size();
    }

    public static boolean isLogged(long userId) {
        return onlineUsers.contains(userId);
    }
}
