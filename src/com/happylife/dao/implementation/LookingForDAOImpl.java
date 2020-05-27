package com.happylife.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.happylife.dao.layer.LookingForDAO;
import com.happylife.dao.layer.LookingForDAOException;
import com.happylife.pojo.LookingFor;

public class LookingForDAOImpl implements LookingForDAO{
	static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet rs;

	
	@Override
	public String insertLookingFor(LookingFor lf) throws LookingForDAOException {
		String msg = "";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("insert into Looking_For values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setLong(1, lf.getId());
			pstmt.setLong(2, lf.getUserId());
			pstmt.setString(3, null);
			pstmt.setString(4, null);
			pstmt.setString(5, null);
			pstmt.setString(6, null);
			pstmt.setString(7, null);
			pstmt.setString(8, null);
			pstmt.setString(9, null);
			pstmt.setString(10, null);
			pstmt.setString(11, null);
			pstmt.setString(12, null);
			pstmt.setString(13, null);
			pstmt.setString(14, null);
			pstmt.setString(15, null);
			pstmt.setString(16, null);
			pstmt.setString(17, null);
			pstmt.setString(18, null);
			pstmt.setString(19, null);
			pstmt.setString(20, null);
			pstmt.setString(21, null);
			pstmt.setString(22, null);
			pstmt.setString(23, null);
			pstmt.setString(24, null);
			
			pstmt.execute();
			
			msg = "insertion of lookingFor element is done successfully";
			System.out.println("Inside insertLookingFor: " + msg);
		}catch(Exception e) {
			msg = "something wrong went with insertion in LookingFor table";
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return msg;
	}
	
	@Override
	public LookingFor getLookingFor(long userId) throws LookingForDAOException {
		LookingFor lf = null;
		try {
			conn = DatabaseConnectivity.doDBConnection();
			pstmt = conn.prepareStatement("select * from LOOKING_FOR where userId=?");
			pstmt.setLong(1,userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				long id = rs.getLong(1);
				userId  = rs.getLong(2);
				String ageL  = rs.getString(3);				
				String ageH = rs.getString(4);					
				String lookingIn  = rs.getString(5);				
				String residencyStatus  = rs.getString(6);				
				String willingToRelocate  = rs.getString(7);
				String ethnicOrigin  = rs.getString(8);				
				String religiousHistory  = rs.getString(9);
				String livingWithInLaws  = rs.getString(10);
				String pray  = rs.getString(11);				
				String sect  = rs.getString(12);
				String maritalStatus = rs.getString(13);
				String children = rs.getString(14);
				String hasPDisability = rs.getString(15);
				String likeToHaveChildren = rs.getString(16);
				String polygamy = rs.getString(17);
				String bodyType  = rs.getString(18);
				String heightL = rs.getString(19);
				String heightH = rs.getString(20);
				String hijabBeard  = rs.getString(21);
				String profession = rs.getString(22);
				String highestQual = rs.getString(23);
				String lookingfor = rs.getString(24);
				lf = new LookingFor(id, userId, ageL, ageH, lookingIn, residencyStatus, willingToRelocate, ethnicOrigin, religiousHistory,
						livingWithInLaws, pray, sect, maritalStatus, children, hasPDisability, likeToHaveChildren, polygamy, bodyType,
						heightL, heightH, hijabBeard, profession, highestQual, lookingfor);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return lf;
	}

	@Override
	public String updateLookingFor(long userId, String... v) throws LookingForDAOException {
		String msg = "";
		if (v.length %2 != 0) return "wrong number of arguments, number of Arguments must be even";
		try {
			conn = DatabaseConnectivity.doDBConnection();
			for(int i=0 ; i< v.length; i+=2) {
				switch(v[i]) {
				case "ageL":
					pstmt = conn.prepareStatement("update looking_for set AgeL=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nAge Lower of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "ageH":
					pstmt = conn.prepareStatement("update looking_for set AgeH=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nAge Higher of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "lookingIn":
					pstmt = conn.prepareStatement("update looking_for set lookingIn=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nLookingIn of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidresidencystatus":
					pstmt = conn.prepareStatement("update looking_for set residency_status=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nResidency status of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "willingtorelocate":
					pstmt = conn.prepareStatement("update looking_for set Willing_To_Relocate=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nWillingToRelocate of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidethnic":
					pstmt = conn.prepareStatement("update looking_for set EthnicOrigin=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nEthnic Origin of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidrh":
					pstmt = conn.prepareStatement("update looking_for set ReligiousHistory=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nReligious History of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidlivewinlaws":
					pstmt = conn.prepareStatement("update looking_for set Living_With_InLaws=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nLivingWithInLaws of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidpray":
					pstmt = conn.prepareStatement("update looking_for set Pray=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nPray of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidsect":
					pstmt = conn.prepareStatement("update looking_for set Sect=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nSect of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidmstatus":
					pstmt = conn.prepareStatement("update looking_for set MaritalStatus=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nMaritial status of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidhavekids":
					pstmt = conn.prepareStatement("update looking_for set HasChildren=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nChildren of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidpdisability":
					pstmt = conn.prepareStatement("update looking_for set HasPDisability=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nPDisability of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidliketohavekids":
					pstmt = conn.prepareStatement("update looking_for set LikeToHaveChildren=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nLikeToHaveChildren of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "polygamy":
					pstmt = conn.prepareStatement("update looking_for set Polygamy=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nPolygamy of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidbodytype":
					pstmt = conn.prepareStatement("update looking_for set BodyType=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nBodyType of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidheightf":
					pstmt = conn.prepareStatement("update looking_for set HeightL=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nheightLower of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidheightto":
					pstmt = conn.prepareStatement("update looking_for set HeightH=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nheightHigher of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidhijaborbeard":
					pstmt = conn.prepareStatement("update looking_for set Hijab_Beard=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nHijabBeard of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidprofession":
					pstmt = conn.prepareStatement("update looking_for set Profession=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nProfession of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "candidhqual":
					pstmt = conn.prepareStatement("update looking_for set HighestQual=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nHighestQual of Looking for updated Successfully";
					System.out.println(msg);
					break;
				case "LookingFor":
					pstmt = conn.prepareStatement("update looking_for set looking_for=? where userId=?");
					pstmt.setString(1,v[i+1]);
					pstmt.setLong(2,userId);
					pstmt.executeUpdate();
					msg = msg + "\nLookingFor of Looking for updated Successfully";
					System.out.println(msg);
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)	conn.close();
				if(pstmt != null)	pstmt.close();
				if(rs != null)		rs.close();
			} catch(Exception e){}
		}
		return msg;
	}

}
