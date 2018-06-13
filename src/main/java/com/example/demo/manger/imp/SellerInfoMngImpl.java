package com.example.demo.manger.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.SellerInfoDto;
import com.example.demo.entity.SellerInfo;
import com.example.demo.manger.SellerInfoMng;
import com.example.demo.redis.RedisService;
import com.example.demo.service.SellerInfoSerive;
import com.example.demo.util.BeanUtilsCopy;
@Service
public class SellerInfoMngImpl implements SellerInfoMng{
	@Autowired
	private SellerInfoSerive sellerInfoSerive;
	@Autowired
	private RedisService redisService;
	
	private static final String  SELLERINFOKEY = "SELLERINFOKEY_";
	@Override
	public boolean save(SellerInfoDto sellerInfoDto) {
		SellerInfo sellerInfo = new SellerInfo();
		BeanUtilsCopy.copyProperties(sellerInfoDto, sellerInfo);
		//在插入时   插入  创建时间和最后修改时间属性
		Date date = new Date();
		sellerInfo.setCreateTime(date);
		sellerInfo.setUpdateTime(date);
		return sellerInfoSerive.insert(sellerInfo);
	}

	@Override
	public boolean update(SellerInfoDto sellerInfoDto) {
		SellerInfo sellerInfo = new SellerInfo();
		BeanUtilsCopy.copyProperties(sellerInfoDto, sellerInfo);
		//在修改时   插入  最后修改时间属性
		Date date = new Date();
		sellerInfo.setUpdateTime(date);
		boolean result = sellerInfoSerive.updateById(sellerInfo);
		//更新成功后更新缓存
		if(result) {
			redisService.set(SELLERINFOKEY+sellerInfo.getId(), sellerInfoDto);
		}
		return true;
	}

	@Override
	public SellerInfoDto find(Long sellerId) {
		SellerInfoDto sellerInfoDto = (SellerInfoDto) redisService.get(SELLERINFOKEY+sellerId);
		if(sellerInfoDto == null) {
			SellerInfo sellerInfo = new SellerInfo();
			sellerInfo = sellerInfoSerive.selectById(sellerId);
			if(sellerInfo != null) {
				BeanUtilsCopy.copyProperties(sellerInfo, sellerInfoDto);
				redisService.set(SELLERINFOKEY+sellerId, sellerInfoDto);
			}
		}
		return sellerInfoDto;
	}

	@Override
	public boolean delete(Long sellerId) {
		boolean result = sellerInfoSerive.deleteById(sellerId);
		if(result) {
			redisService.del(SELLERINFOKEY+sellerId);
		}
		return result;
	}

}
