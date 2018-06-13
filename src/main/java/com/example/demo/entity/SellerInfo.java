package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**  
* @ClassName: SellerInfo  
* @Description: TODO 卖家信息表
* @author Cuixc  
* @date 2018年6月6日  
*    
*/  
public class SellerInfo implements Serializable{
	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/ 
	private static final long serialVersionUID = -6182038286749649970L;
	private Long id;
	private String username;
	private String password;
	private String openid;
	private Date createTime;
	private Date updateTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
		return "SellerInfo [id=" + id + ", username=" + username + ", password=" + password + ", openid=" + openid
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
	
}
