package com.poi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poi.model.Product;
import com.poi.service.ProductService;

@Controller
@RequestMapping("/admin")
	public class AdminController {
	@Autowired
	private ProductService productService;

	// 메소드 단위의 리ㅞ스트 맵핑
	// 여기서는 어떤 url설정없으니까 위에 있는거 그대로 가져 온다는거
	@RequestMapping
	public String adminPage() {
		return "admin";

	}

	@RequestMapping("/productInventory")
	// db조회해서 model에 저장하는거.
	// 이 일은 전적으로 dao에 시킨다.
	public String getProducts(Model model) { // controller -> model -> view
		// 이작업은 dao거치는것도 포함되어있어
		List<Product> products = productService.getProducts();
		// 가져온 product를 model에다 넣는 작업. key,value 값으로..
		model.addAttribute("products", products);

		return "productInventory";
	}
}
