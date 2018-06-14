package com.example.demo.manger;

import java.util.List;

import com.example.demo.DTO.SellerInfoDto;

public interface SellerInfoMng {
	boolean save(SellerInfoDto sellerInfoDto);
	boolean update(SellerInfoDto sellerInfoDto);
	SellerInfoDto find(Long sellerId);
	boolean delete(Long sellerId);
	List<SellerInfoDto> findAll();
	/**  
	* @Title: find  
	* @Description: TODO(根据指定条件查询商户)  
	* @param @param sellerInfoDto
	* @param @return    参数  
	* @return List<SellerInfoDto>    返回类型  
	* @throws  
	*/  
	List<SellerInfoDto> find(SellerInfoDto sellerInfoDto);
}
