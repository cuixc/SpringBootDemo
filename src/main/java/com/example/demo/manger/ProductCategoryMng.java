package com.example.demo.manger;

import java.util.List;

import com.example.demo.DTO.ProductCategoryDto;


public interface ProductCategoryMng {
	boolean save(ProductCategoryDto productCategoryDto);
	List<ProductCategoryDto> find(ProductCategoryDto productCategoryDto);
	ProductCategoryDto findById(Long categoryDtoId);
	List<ProductCategoryDto> findAll();
	boolean update(ProductCategoryDto productCategoryDto);
}
