package com.example.demo.manger.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.DTO.ProductInfoDto;
import com.example.demo.entity.ProductInfo;
import com.example.demo.manger.ProductInfoMng;
import com.example.demo.redis.RedisService;
import com.example.demo.service.ProductInfoService;
import com.example.demo.util.BeanUtilsCopy;
import com.google.common.collect.Lists;

public class ProductInfoMngImpl implements ProductInfoMng {
	@Autowired
	private ProductInfoService productInfoService;
	@Autowired
	private RedisService redisService;
	
	private static final String PRODUCTINFOBYID = "PRODUCTINFOBYID_";
	
	@Override
	public ProductInfoDto findById(Long productId) {
		if(productId == null) return null;
		ProductInfoDto productInfoDto = (ProductInfoDto) redisService.get(PRODUCTINFOBYID+productId);
		if(productInfoDto != null) return productInfoDto;
		
		productInfoDto = new ProductInfoDto();
		ProductInfo productInfo = productInfoService.selectById(productId);
		if(productInfo != null) {
			BeanUtilsCopy.copyProperties(productInfo, productInfoDto);
			redisService.set(PRODUCTINFOBYID+productId, productInfoDto);
		}
		return productInfoDto;
	}

	@Override
	public List<ProductInfoDto> find(ProductInfoDto productInfoDto) {
		if(productInfoDto == null) return null;
		ProductInfo productInfo = new ProductInfo();
		BeanUtilsCopy.copyProperties(productInfoDto, productInfo);
		List<ProductInfo> productInfos = productInfoService.selectList(
				new EntityWrapper<ProductInfo>(productInfo).orderBy("update_time"));
		if(productInfos == null || productInfos.size() == 0) return null;
		List<ProductInfoDto> productInfoDtos = Lists.newArrayList();
		BeanUtilsCopy.CopyList(productInfos, ProductInfoDto.class);
		return productInfoDtos;
	}

	@Override
	public boolean save(ProductInfoDto productInfoDto) {
		if(productInfoDto == null) return false;
		ProductInfo productInfo = new ProductInfo();
		BeanUtilsCopy.copyProperties(productInfoDto, productInfo);
		// updatetime  and createtime
		productInfo.setCreateTime(new Date());
		productInfo.setUpdateTime(new Date());
		return productInfoService.insert(productInfo);
	}

	@Override
	public boolean update(ProductInfoDto productInfoDto) {
		if(productInfoDto == null) return false;
		ProductInfo productInfo = new ProductInfo();
		BeanUtilsCopy.copyProperties(productInfoDto, productInfo);
		//updatetime
		productInfo.setUpdateTime(new Date());
		return productInfoService.updateById(productInfo);
	}

	@Override
	public boolean delete(Long productId) {
		if(productId == null) return false;
		boolean result = productInfoService.deleteById(productId);
		if(result) {
			redisService.del(PRODUCTINFOBYID+productId);
		}
		return result;
	}
	
}
