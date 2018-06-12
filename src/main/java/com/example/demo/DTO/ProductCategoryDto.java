package com.example.demo.DTO;

import java.util.Date;

public class ProductCategoryDto {
	private Long id;
    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;



    
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

	
	
}
