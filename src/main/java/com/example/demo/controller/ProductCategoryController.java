package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		if(productCategoryDto.getSellerId() == null) {
			//TODO  增加当前登陆商户判断   productCategoryDto中sellerid字段必填、
		}
		boolean result = productCategoryMng.save(productCategoryDto);
		return result;
	}
	@RequestMapping(value = "find.do",method=RequestMethod.POST)
	@ApiOperation(value="查询类目")
	public List<ProductCategoryDto> find(ProductCategoryDto productCategoryDto) {
		if(productCategoryDto.getSellerId() == null) {
			//TODO  增加当前登陆商户判断   productCategoryDto中sellerid字段必填、
		}
		List<ProductCategoryDto> result = productCategoryMng.find(productCategoryDto);
		return result;
	}
	@RequestMapping(value = "update.do",method=RequestMethod.POST)
	@ApiOperation(value="修改类目")
	public boolean update(ProductCategoryDto productCategoryDto) {
		if(productCategoryDto.getSellerId() == null) {
			//TODO  增加当前登陆商户判断   productCategoryDto中sellerid字段必填、
		}
		boolean result = productCategoryMng.update(productCategoryDto);
		return result;
	}
	
	@RequestMapping(value = "delete.do",method=RequestMethod.POST)
	@ApiOperation(value="修改类目")
	public boolean delete(Long productCategoryDtoId) {
		
		boolean result = productCategoryMng.delete(productCategoryDtoId);
		return result;
	}
}
