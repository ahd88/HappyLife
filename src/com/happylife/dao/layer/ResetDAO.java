package com.happylife.dao.layer;

public interface ResetDAO {
	public String activateAccount(String emailId, String token) throws ResetDAOException;
	public String addResetLink(String email)throws ResetDAOException;
	public String validateToken(String token) throws ResetDAOException;
}