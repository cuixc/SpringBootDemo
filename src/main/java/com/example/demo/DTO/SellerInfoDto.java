package com.example.demo.DTO;

public class SellerInfoDto {
	private String username;
	private String password;
	private String openid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public String toString() {
		return "SellerInfoDto [username=" + username + ", password=" + password + ", openid=" + openid + "]";
	}
	
}
