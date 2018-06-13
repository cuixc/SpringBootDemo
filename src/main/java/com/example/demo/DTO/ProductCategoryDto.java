package com.example.demo.DTO;

import io.swagger.annotations.ApiParam;

public class ProductCategoryDto {
	private Long id;
    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 所属商户id. */
    @ApiParam(value="商户id必填")
    private String sellerId;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "ProductCategoryDto [id=" + id + ", categoryName=" + categoryName + ", categoryType=" + categoryType
				+ ", sellerId=" + sellerId + "]";
	}

	
	
}
