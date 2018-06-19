package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.SellerInfoDto;
import com.example.demo.manger.SellerInfoMng;
import com.example.demo.util.ErrorEnum;
import com.example.demo.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Seller")
@Api(value="商户处理")
public class SellerController {
	private static final Logger log = LoggerFactory.getLogger(SellerController.class);
	@Autowired
	private SellerInfoMng sellerInfoMng;
	
	
	@RequestMapping(value = "/save.do",method= RequestMethod.POST)
	@ApiOperation(value="商户添加")
	public R save(SellerInfoDto sellerInfoDto) {
		log.info("===========商户添加==========");
		//用户名密码必填
		if(sellerInfoDto.getUsername().isEmpty() || sellerInfoDto.getPassword().isEmpty()) {
			return R.error();
		}
		//查询用户名是否存在
		List<SellerInfoDto> sellerInfoDtos = sellerInfoMng.find(sellerInfoDto);
		if(sellerInfoDtos != null || sellerInfoDtos.size() != 0) {
			return R.error(ErrorEnum.E_201.getErrorCode(),ErrorEnum.E_201.getErrorMsg());
		}
		boolean result = sellerInfoMng.save(sellerInfoDto);
		log.info("result=="+result);
		if(result) {
			return R.ok();
		}
		return R.error();
		
	}
	
	@RequestMapping(value = "/update.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户修改")
	public R update(SellerInfoDto sellerInfoDto) {
		log.info("===========商户修改==========");
		boolean result = sellerInfoMng.update(sellerInfoDto);
		log.info("result=="+result);
		if(result) {
			return R.ok();
		}
		return R.error();
		
	}
	
	@RequestMapping(value = "/findBySellerId.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户按id查询")
	public SellerInfoDto findBySellerId(Long sellerId) {
		log.info("===========商户按id查询=========="+sellerId);
		SellerInfoDto result = sellerInfoMng.find(sellerId);
		return result;
		
	}
	
	@RequestMapping(value = "/findAll.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户查询all")
	public List<SellerInfoDto> findAll() {
		log.info("===========商户查询all==========");
		List<SellerInfoDto> result = sellerInfoMng.findAll();
		return result;
		
	}
	@RequestMapping(value = "/find.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户查询all")
	public List<SellerInfoDto> find(SellerInfoDto sellerInfoDto) {
		log.info("===========商户查询==========");
		List<SellerInfoDto> result = sellerInfoMng.find(sellerInfoDto);
		return result;
		
	}
	@RequestMapping(value = "/delectBySellerId.do",method= {RequestMethod.POST})
	@ApiOperation(value="商户删除")
	public R save(Long sellerId) {
		log.info("===========商户删除==========");
		boolean result = sellerInfoMng.delete(sellerId);
		log.info("result=="+result);
		if(result) {
			return R.ok();
		}
		return R.error();
		
	}
	
}
