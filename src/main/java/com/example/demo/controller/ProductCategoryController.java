package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProductCategoryDto;
import com.example.demo.manger.ProductCategoryMng;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/prodyctcategory")
@Api(value="商品类目")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryMng productCategoryMng;
	@RequestMapping(value = "save.do",method=RequestMethod.POST)
	@ApiOperation(value="保存类目")
	public boolean save(ProductCategoryDto productCategoryDto) {
		boolean result = productCategoryMng.save(productCategoryDto);
		return result;
	}
}
