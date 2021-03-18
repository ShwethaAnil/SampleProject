package com.mphasis.pms.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mphasis.pms.pojos.Guser;
import com.mphasis.pms.util.DbUtil;

public class GuserDaoImpl implements GuserDao {
	Connection con=null;
	public GuserDaoImpl() {
		con=DbUtil.createConnection();
	}

	@Override
	public int insertUser(Guser user) {
		int i=0;
		try {
			//create sequence guser_seq start with 1 increment 1;
			PreparedStatement pst=con.prepareStatement(
					"insert into guser values(guser_seq.nextval,?,?,sysdate,'customer')");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPass());
			
			i=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Guser login(String uname, String pass) {
		Guser guser=new Guser();
		try {
			PreparedStatement pst=con.prepareStatement(
					"select * from guser where username=? and pass=?");
			pst.setString(1, uname);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				guser.setUserid(rs.getInt(1));
				guser.setUsername(rs.getString(2));
				guser.setPass(rs.getString(3));
				java.sql.Date sqlDate =rs.getDate(4);
				guser.setAcc_created_date(sqlDate.toLocalDate());
				guser.setRole(rs.getString(5));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return guser;
	}

	@Override
	public int updatePassword(String oldPass, String newPass,String uname) {
		int i=0;
		try {
			PreparedStatement pst=con.prepareStatement("update guser set pass=? where username=? and pass=?");
			pst.setString(1, newPass);
			pst.setString(2, uname);
			pst.setString(3, oldPass);
			i=pst.executeUpdate();
			System.out.println(i);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Guser retiveUser(String uname) {
		Guser guser=new Guser();
		try {
			PreparedStatement pst=con.prepareStatement(
					"select * from guser where username=?");
			pst.setString(1, uname);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				guser.setUserid(rs.getInt(1));
				guser.setUsername(rs.getString(2));
				guser.setPass(rs.getString(3));
				java.sql.Date sqlDate =rs.getDate(4);
				guser.setAcc_created_date(sqlDate.toLocalDate());
				guser.setRole(rs.getString(5));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return guser;
	}

	@Override
	public Guser forgotPassowrd(String newPass, String uname) {
		Guser guser=new Guser();
		try {
			PreparedStatement pst=con.prepareStatement(
					"select * from guser where username=?");
			pst.setString(1, uname);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				guser.setUserid(rs.getInt(1));
				guser.setUsername(rs.getString(2));
				guser.setPass(rs.getString(3));
				java.sql.Date sqlDate =rs.getDate(4);
				guser.setAcc_created_date(sqlDate.toLocalDate());
				guser.setRole(rs.getString(5));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return guser;
	}

}
