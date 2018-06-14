package com.example.demo.manger;

import java.util.List;

import com.example.demo.DTO.ProductInfoDto;

public interface ProductInfoMng {
	ProductInfoDto findById(Long productId);
	List<ProductInfoDto> find(ProductInfoDto productInfoDto);
	boolean save(ProductInfoDto productInfoDto);
	boolean update(ProductInfoDto productInfoDto);
	boolean delete(Long productId);
}
