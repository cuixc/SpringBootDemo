package com.example.demo.manger;

import java.util.List;

import com.example.demo.DTO.SellerInfoDto;

public interface SellerInfoMng {
	boolean save(SellerInfoDto sellerInfoDto);
	boolean update(SellerInfoDto sellerInfoDto);
	SellerInfoDto find(Long sellerId);
	boolean delete(Long sellerId);
	List<SellerInfoDto> findAll();
}
