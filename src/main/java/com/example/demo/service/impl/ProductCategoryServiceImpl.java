package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.ProductCategoryDao;
import com.example.demo.entity.ProductCategory;
import com.example.demo.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDao, ProductCategory> implements ProductCategoryService {
	
}
