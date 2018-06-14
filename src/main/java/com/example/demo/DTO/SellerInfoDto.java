package com.example.demo.DTO;

import java.io.Serializable;

public class SellerInfoDto implements Serializable{
	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/ 
	private static final long serialVersionUID = 1762005682034018059L;
	private String id;
	private String username;
	private String password;
	private String openid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
		return "SellerInfoDto [id=" + id + ", username=" + username + ", password=" + password + ", openid=" + openid
				+ "]";
	}
	
}
