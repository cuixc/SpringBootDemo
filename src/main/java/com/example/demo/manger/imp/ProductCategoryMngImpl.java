package com.example.demo.manger.imp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductCategoryDto;
import com.example.demo.entity.ProductCategory;
import com.example.demo.manger.ProductCategoryMng;
import com.example.demo.redis.RedisService;
import com.example.demo.service.ProductCategoryService;

@Service
public class ProductCategoryMngImpl implements ProductCategoryMng{
	@Autowired
	private RedisService redisService;
	@Autowired
	private ProductCategoryService productCategoryService;
	private final static String cacheKeyByCategory = "ProductCategory_";
	@Override
	public boolean save(ProductCategoryDto productCategoryDto) {
		ProductCategory productCategory = new ProductCategory();
		BeanUtils.copyProperties(productCategoryDto, productCategory);
		boolean result = productCategoryService.insert(productCategory);
		if(result) {
			redisService.set(cacheKeyByCategory+productCategory.getId(), productCategory);
			return true;
		}
		return false;
	}



}
