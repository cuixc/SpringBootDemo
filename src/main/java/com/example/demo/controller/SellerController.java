package com.example.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.SellerInfoDto;
import com.example.demo.manger.SellerInfoMng;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Seller")
@Api(value="商户处理")
public class SellerController {
	private static final Logger log = Logger.getLogger(SellerController.class);
	@Autowired
	private SellerInfoMng sellerInfoMng;
	
	
	@RequestMapping(value = "/save.do",method= RequestMethod.POST)
	@ApiOperation(value="商户添加")
	public boolean save(SellerInfoDto sellerInfoDto) {
		log.info("===========商户添加==========");
		boolean result = sellerInfoMng.save(sellerInfoDto);
		log.info("result=="+result);
		return result;
		
	}
	
	@RequestMapping(value = "/update.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户修改")
	public boolean update(SellerInfoDto sellerInfoDto) {
		log.info("===========商户修改==========");
		boolean result = sellerInfoMng.update(sellerInfoDto);
		log.info("result=="+result);
		return result;
		
	}
	
	@RequestMapping(value = "/findBySellerId.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户按id查询")
	public SellerInfoDto findBySellerId(Long sellerId) {
		log.info("===========商户按id查询==========");
		SellerInfoDto result = sellerInfoMng.find(sellerId);
		log.info("result=="+result.toString());
		return result;
		
	}
	
	@RequestMapping(value = "/findAll.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户查询all")
	public List<SellerInfoDto> findAll() {
		log.info("===========商户查询all==========");
		List<SellerInfoDto> result = sellerInfoMng.findAll();
		return result;
		
	}
	
	@RequestMapping(value = "/delectBySellerId.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户删除")
	public boolean save(Long sellerId) {
		log.info("===========商户删除==========");
		boolean result = sellerInfoMng.delete(sellerId);
		log.info("result=="+result);
		return result;
		
	}
	
}
