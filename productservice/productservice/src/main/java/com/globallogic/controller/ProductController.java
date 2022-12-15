package com.globallogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.dto.ProductDto;
import com.globallogic.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;

	@PostMapping("/addProduct")
	ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto)
	{
		return new ResponseEntity<ProductDto>(service.addProduct(productDto),HttpStatus.CREATED);
	}
	@GetMapping("/getProduct")
	ResponseEntity<List<ProductDto>> getAllProduct()
	{
		List<ProductDto> listOfProduct=service.getAllProducts();
		return new ResponseEntity<List<ProductDto>>(listOfProduct,HttpStatus.OK);
	}
	@GetMapping("/getProduct/{productId}")
	ResponseEntity<ProductDto> getProduct(@PathVariable int productId)
	{
		return new ResponseEntity<ProductDto>(service.getProductById(productId),HttpStatus.FOUND);
	}
}
