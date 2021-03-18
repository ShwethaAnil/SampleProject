package com.mphasis.pms.daos;

import com.mphasis.pms.pojos.Guser;

public interface GuserDao {

	public int insertUser(Guser user);
	public Guser login(String uname,String pass);
	public int updatePassword(String oldPass,String newPass, String uname);
	public Guser retiveUser(String uname);
	public Guser forgotPassowrd(String newPass,String uname);
}
