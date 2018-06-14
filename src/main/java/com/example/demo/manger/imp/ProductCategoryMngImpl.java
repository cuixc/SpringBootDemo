package com.example.demo.manger.imp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.DTO.ProductCategoryDto;
import com.example.demo.entity.ProductCategory;
import com.example.demo.manger.ProductCategoryMng;
import com.example.demo.redis.RedisService;
import com.example.demo.service.ProductCategoryService;
import com.example.demo.util.BeanUtilsCopy;
import com.google.common.collect.Lists;

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
		BeanUtilsCopy.copyProperties(productCategoryDto, productCategory);
		//insert 时   设置创建时间为当前时间
		productCategory.setCreateTime(new Date());
		boolean result = productCategoryService.insert(productCategory);
		return result;
	}
	@Override
	public List<ProductCategoryDto> find(ProductCategoryDto productCategoryDto) {
		ProductCategory productCategory = new ProductCategory();
		BeanUtilsCopy.copyProperties(productCategoryDto, productCategory);
		List<ProductCategory> productCategories = 
				productCategoryService.selectList(new EntityWrapper<ProductCategory>(productCategory));
		List<ProductCategoryDto> productCategoryDtos = BeanUtilsCopy.CopyList(productCategories, ProductCategoryDto.class);
		return productCategoryDtos;
	}
	@Override
	public ProductCategoryDto findById(Long categoryDtoId) {
		ProductCategoryDto productCategoryDto = (ProductCategoryDto) redisService.get(cacheKeyByCategory+categoryDtoId);
		if(productCategoryDto == null) {
			ProductCategory productCategory = productCategoryService.selectById(categoryDtoId);
			BeanUtilsCopy.copyProperties(productCategory, productCategoryDto);
			redisService.set(cacheKeyByCategory+productCategoryDto.getId(), productCategoryDto);
		}
		return productCategoryDto;
	}
	@Override
	public List<ProductCategoryDto> findAll() {
		List<ProductCategoryDto> productCategoryDtos = Lists.newArrayList();
		List<ProductCategory> productCategories = productCategoryService.selectList(new EntityWrapper<ProductCategory>().orderBy("update_time"));
		if(productCategories != null && !productCategories.isEmpty()) {
			productCategoryDtos = BeanUtilsCopy.CopyList(productCategories, ProductCategoryDto.class);
		}
		return productCategoryDtos;
	}
	@Override
	public boolean update(ProductCategoryDto productCategoryDto) {
		if(productCategoryDto != null) {
			ProductCategory productCategory = new ProductCategory();
			BeanUtilsCopy.copyProperties(productCategoryDto, productCategory);
			//update 时  更新当前时间为最后修改时间
			productCategory.setUpdateTime(new Date());
			boolean result = productCategoryService.updateById(productCategory);
			//更新成功后更新缓存
			if(result) {
				redisService.set(cacheKeyByCategory+productCategoryDto.getId(), productCategoryDto);
			}
			return result;
		}
		return false;
	}
	@Override
	public boolean delete(Long categoryDtoId) {
		boolean result = productCategoryService.deleteById(categoryDtoId);
		if(result) {
			redisService.del(cacheKeyByCategory+categoryDtoId);
		}
		return result;
	}



}
