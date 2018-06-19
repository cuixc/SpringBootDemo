package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProductCategoryDto;
import com.example.demo.manger.ProductCategoryMng;
import com.example.demo.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**  
* @ClassName: ProductCategoryController  
* @Description: TODO 商品类目控制类
* @author cuixc  
* @date 2018年6月19日  
*    
*/  
@RestController
@RequestMapping("/prodyctcategory")
@Api(value="商品类目")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryMng productCategoryMng;
	@RequestMapping(value = "save.do",method=RequestMethod.POST)
	@ApiOperation(value="保存类目")
	public R save(ProductCategoryDto productCategoryDto) {
		if(productCategoryDto.getSellerId() == null) {
			//TODO  增加当前登陆商户判断   productCategoryDto中sellerid字段必填、
			return R.error("参数错误  商户Id为null");
		}
		boolean result = productCategoryMng.save(productCategoryDto);
		if(result) return R.ok();
		return R.error();
	}
	@RequestMapping(value = "find.do",method=RequestMethod.POST)
	@ApiOperation(value="查询类目")
	public R find(ProductCategoryDto productCategoryDto) {
		if(productCategoryDto.getSellerId() == null) {
			return R.error("参数错误  商户Id为null");
		}
		List<ProductCategoryDto> result = productCategoryMng.find(productCategoryDto);
		R r = new R();
		r.put("productcategorys", result);
		return r;
	}
	@RequestMapping(value = "update.do",method=RequestMethod.POST)
	@ApiOperation(value="修改类目")
	public R update(ProductCategoryDto productCategoryDto) {
		if(productCategoryDto.getSellerId() == null) {
			return R.error("参数错误  商户Id为null");
		}
		boolean result = productCategoryMng.update(productCategoryDto);
		if(result) return R.ok();
		return R.error();
	}
	
	@RequestMapping(value = "delete.do",method=RequestMethod.POST)
	@ApiOperation(value="修改类目")
	public R delete(Long productCategoryDtoId) {
		if(productCategoryDtoId == null) return R.error(); 
		boolean result = productCategoryMng.delete(productCategoryDtoId);
		if(result) return R.ok();
		return R.error();
	}
}
