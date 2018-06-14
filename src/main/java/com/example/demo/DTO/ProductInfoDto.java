package com.example.demo.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductInfoDto implements Serializable{

	private static final long serialVersionUID = 7671762813573042647L;

	private Long productId; // 商品ID
	private String productName; //商品名称
	private BigDecimal productPrice; //商品单价
	private Integer productStock;  //库存
	private String productDescription; //描述
	private String productIcon; //小图
    private Integer productStatus; //状态   0正常 1下架
    private Integer categoryType; //类目编号
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductIcon() {
		return productIcon;
	}
	public void setProductIcon(String productIcon) {
		this.productIcon = productIcon;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public Integer getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
	@Override
	public String toString() {
		return "ProductInfoDto [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productStock=" + productStock + ", productDescription=" + productDescription
				+ ", productIcon=" + productIcon + ", productStatus=" + productStatus + ", categoryType=" + categoryType
				+ "]";
	}
    
    
}
