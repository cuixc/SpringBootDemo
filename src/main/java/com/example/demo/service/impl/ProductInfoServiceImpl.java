package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.ProductInfoDao;
import com.example.demo.entity.ProductInfo;
import com.example.demo.service.ProductInfoService;
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoDao, ProductInfo> implements ProductInfoService {

}
