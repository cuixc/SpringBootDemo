package com.example.demo.entity;

/**  
* @ClassName: SellerInfo  
* @Description: TODO 卖家信息表
* @author Cuixc  
* @date 2018年6月6日  
*    
*/  
public class SellerInfo {
	private String sellerId;
	private String username;
	private String password;
	private String openid;
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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
		return "SellerInfo [sellerId=" + sellerId + ", username=" + username + ", password=" + password + ", openid="
				+ openid + "]";
	}
	
}
