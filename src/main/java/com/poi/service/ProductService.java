package com.poi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poi.dao.ProductDao;
import com.poi.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProducts(){
		//productDao에서 getProducts()를해서 값을 controller 클래스에 전달
		//List<Product> products = productService.getProduct();
		//여기 리턴값이 결국 products
		return productDao.getProducts();
	}
}
