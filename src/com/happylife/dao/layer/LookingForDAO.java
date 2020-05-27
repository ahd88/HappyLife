package com.happylife.dao.layer;

import com.happylife.pojo.LookingFor;

public interface LookingForDAO {
	public String insertLookingFor(LookingFor lookingfor)throws LookingForDAOException;
	public String updateLookingFor(long userId, String ...v)throws LookingForDAOException;
	public LookingFor getLookingFor(long userId)throws LookingForDAOException;
}
