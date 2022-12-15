package com.globallogic.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.ProductDto;
import com.globallogic.modal.Product;
import com.globallogic.repository.ProductRepository;
import com.globallogic.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repository;

	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product=new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
	    repository.save(product);
		return productDto;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> responseList=new ArrayList<>();
		List<Product>  requestList=repository.findAll();
		for(Product product:requestList)
		{
			ProductDto productDto=new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setProductPrice(product.getProductPrice());
			responseList.add(productDto);
		}
		return responseList;
	}

	@Override
	public ProductDto getProductById(int productId) {
		Product product=repository.findById(productId).get();
		ProductDto productDto=new ProductDto();
		productDto.setProductId(productId);
		productDto.setProductName(product.getProductName());
		productDto.setProductPrice(product.getProductPrice());
		return productDto;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDto updataProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
