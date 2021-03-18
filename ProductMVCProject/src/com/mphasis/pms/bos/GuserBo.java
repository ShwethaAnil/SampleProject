package com.mphasis.pms.bos;

import com.mphasis.pms.exceptions.BuisnessException;
import com.mphasis.pms.pojos.Guser;

public interface GuserBo {
	
	public boolean login(String uname,String pass)throws BuisnessException;
	public void register(Guser guser)throws BuisnessException;
	public int changePassword(String oldPass,String newPass, String uname);

}
