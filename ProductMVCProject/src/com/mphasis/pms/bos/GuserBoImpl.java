package com.mphasis.pms.bos;

import com.mphasis.pms.daos.GuserDao;
import com.mphasis.pms.daos.GuserDaoImpl;
import com.mphasis.pms.exceptions.BuisnessException;
import com.mphasis.pms.exceptions.RecordNotFoundException;
import com.mphasis.pms.pojos.Guser;

public class GuserBoImpl implements GuserBo {
	GuserDao guserDao;

	public GuserBoImpl() {
		guserDao = new GuserDaoImpl();
	}

	@Override
	public boolean login(String uname, String pass) throws BuisnessException {
		Guser guser = guserDao.login(uname, pass);
		try {
			if (guser.getUsername().equalsIgnoreCase(uname)) {
				if (guser.getPass().equalsIgnoreCase(pass)) {
					return true;
				} else {
					throw new BuisnessException("Password is invalid");
				}
			} else {
				throw new BuisnessException("Usename is invalid");
			}
		} catch (NullPointerException e) {
			throw new BuisnessException("invalid username or password");
		}

	}

	@Override
	public void register(Guser guser) throws BuisnessException {
		if (guser.getUsername().matches("[a-zA-Z]*")) {
			if (guser.getPass().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8}$")) {
				int i = guserDao.insertUser(guser);
				if (i <= 0) {
					throw new RecordNotFoundException("Problem with User Registration");
				}
			} else {
				throw new BuisnessException(
						"Password should contain 1upper case 1 lower case , 1 special and 1 number with 8 length");
			}

		} else {
			throw new BuisnessException("Invalid name");
		}

	}

	@Override
	public int changePassword(String oldPass, String newPass, String uname) {
		int i = 0;
		Guser guser = guserDao.retiveUser(uname);
		if (newPass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8}$")) {
			if(!oldPass.equalsIgnoreCase(newPass)) {
			if (guser.getPass().equals(oldPass)) {
				i = guserDao.updatePassword(oldPass, newPass, uname);
			} else {
				throw new RecordNotFoundException("Old Password didnot match");
			}
		}else {
			throw new RecordNotFoundException("old password should not match with new password");
		}
		}else {
			throw new RecordNotFoundException(
					"Password should contain 1upper case 1 lower case , 1 special and 1 number with 8 length");
		}
		return i;
	}

}
