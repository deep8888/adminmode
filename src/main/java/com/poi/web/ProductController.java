package com.poi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poi.model.Product;
import com.poi.service.ProductService;

@Controller
public class ProductController {
	//우리 목표는 controller가 service를 호출하는거고
	//service가 dao를 호출하는 그런 루트!
	
	//bean 생성할때 자동으로 묶어줌 
	@Autowired
	private ProductService productService;
	
	//사용자가 /products 라는 url로 들어올경우 
	@RequestMapping("/products")
	//아래의 메소드를 실행시킨다.
	public String getProducts(Model model) {
		
		//getProduct() 메소드를 이용해 리스트에 프로덕트를 저장한다.
		List<Product> products = productService.getProducts();
		//가져온 product를 model에다 넣는 작업. key,value 값으로..
		System.out.println(products);
		model.addAttribute("products", products); 
		//view의 logical name
		return "products";
	}
}