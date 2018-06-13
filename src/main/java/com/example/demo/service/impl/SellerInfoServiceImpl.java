package com.example.demo.service.impl;


import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.dao.SellerInfoDao;
import com.example.demo.entity.SellerInfo;
import com.example.demo.service.SellerInfoSerive;
@Service
public class SellerInfoServiceImpl extends ServiceImpl<SellerInfoDao, SellerInfo> implements SellerInfoSerive{
	
}
