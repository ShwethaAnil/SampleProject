package com.mphasis.pms.pojos;

import java.time.LocalDate;

public class Guser {
	private int userid;
	private String username;//unique
	private String pass;
	private LocalDate acc_created_date;
	private String role;//admin or customer
	public Guser() {
		
	}

	public Guser(int userid, String username, String pass, LocalDate acc_created_date) {
		super();
		this.userid = userid;
		this.username = username;
		this.pass = pass;
		this.acc_created_date = acc_created_date;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public LocalDate getAcc_created_date() {
		return acc_created_date;
	}

	public void setAcc_created_date(LocalDate acc_created_date) {
		this.acc_created_date = acc_created_date;
	}

	@Override
	public String toString() {
		return "Guser [userid=" + userid + ", username=" + username + ", pass=" + pass + ", acc_created_date="
				+ acc_created_date + "role"+role+ "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
