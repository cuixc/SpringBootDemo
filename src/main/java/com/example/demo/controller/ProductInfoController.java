package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProductInfoDto;
import com.example.demo.manger.ProductInfoMng;
import com.example.demo.util.R;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/productinfo",method=RequestMethod.POST)
public class ProductInfoController {
	@Autowired
	private ProductInfoMng productInfoMng;
	@RequestMapping(value="/save.do")
	@ApiOperation(value="商品详情保存")
	public R save(ProductInfoDto productInfoDto) {
		boolean result = productInfoMng.save(productInfoDto);
		if(result) return R.ok();
		return R.error();
	}
}
