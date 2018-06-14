package com.example.demo.manger.imp;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.DTO.SellerInfoDto;
import com.example.demo.entity.SellerInfo;
import com.example.demo.manger.SellerInfoMng;
import com.example.demo.redis.RedisService;
import com.example.demo.service.SellerInfoSerive;
import com.example.demo.util.BeanUtilsCopy;
import com.google.common.collect.Lists;
@Service
public class SellerInfoMngImpl implements SellerInfoMng{
	private static final Logger log = Logger.getLogger(SellerInfoMngImpl.class);
	
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
		log.info("======find======");
		if(sellerInfoDto == null) {
			sellerInfoDto = new SellerInfoDto();
			log.info("sellerInfoDto is null");
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

	@Override
	public List<SellerInfoDto> findAll() {
		List<SellerInfo> sellerInfos = sellerInfoSerive.selectList(new EntityWrapper<SellerInfo>().orderBy("update_time"));
		List<SellerInfoDto> sellerInfoDtos = Lists.newArrayList();
		if(sellerInfos != null && !sellerInfos.isEmpty()) {
			sellerInfoDtos = BeanUtilsCopy.CopyList(sellerInfos, SellerInfoDto.class);
		}
		return sellerInfoDtos;
	}

	@Override
	public List<SellerInfoDto> find(SellerInfoDto sellerInfoDto) {
		if(sellerInfoDto == null) {
			return null;
		}
		SellerInfo sellerInfo = new SellerInfo();
		BeanUtilsCopy.copyProperties(sellerInfoDto, sellerInfo);
		List<SellerInfo> sellerInfos = sellerInfoSerive.selectList(new EntityWrapper<SellerInfo>(sellerInfo)
												.orderBy("update_time"));
		if(sellerInfos == null || sellerInfos.size() == 0) return null;
		List<SellerInfoDto> sellerInfoDtos = BeanUtilsCopy.CopyList(sellerInfos,SellerInfoDto.class);
		return sellerInfoDtos;
	}

}
