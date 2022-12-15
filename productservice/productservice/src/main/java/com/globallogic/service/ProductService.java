package com.globallogic.service;

import java.util.List;

import com.globallogic.dto.ProductDto;

public interface ProductService {

	ProductDto addProduct(ProductDto productDto);
	List<ProductDto> getAllProducts();
	ProductDto getProductById(int productId);
	void deleteProduct(int productId);
	ProductDto updataProduct(ProductDto productDto);
}
