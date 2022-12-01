package com.ayushkaam.model;




public class AdminLogin {
	private String mobileNo;
	private String password;
	
	public AdminLogin() {
		
	}

	public AdminLogin(String mobileNo, String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
