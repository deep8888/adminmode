package com.poi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		product.setCategory("컴퓨터");
		model.addAttribute("product", product);
		return "addProduct";
	}
	
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.POST)
	//post 메소드에 들어있는 객체가 Product형식으로 들어와서 Product 형식으로 변수 product로 저장이 된다. //알아서 바인딩!
	//이 메소드는 db에 create하는거임.
	public String addProductPost(@Valid Product product, BindingResult result) {
		//에러가 있다면 출력하는것
		if(result.hasErrors()) {
			System.out.println("Form data has some errors");
			//결과에 에러값들을 errors라는 리스트에 저장
			List<ObjectError> errors = result.getAllErrors();
			//errors리스트를 돌면서 product에서 설장한 에레메세지들을 콘솔에 출력
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			//에러가있으면 다시 상품추가 페이지로 가게한다.
			return "addProduct";
		}
		
		
		if( !productService.addProduct(product))
			System.out.println("상품 추가 실패했습니당..");

		return "redirect:/admin/productInventory";
	}
	
	@RequestMapping(value="/productInventory/deleteProduct/{id}", method=RequestMethod.GET)
	//@PathVariable 경로안에 있는 값을 빼오겠다는겨
	public String deleteProduct(@PathVariable int id) {

		//삭제 실패하면 false (0)
		//true가 아니면! = 1이 아니면
		if( ! productService.deleteProduct(id) ) {
			System.out.println("deleteing product cannot be done");
		}
		
		return "redirect:/admin/productInventory";
	}
	
	//상품리스트 업데이트페이지!
	@RequestMapping(value="/productInventory/updateProduct/{id}", method=RequestMethod.GET)
	//@PathVariable 경로안에 있는 값을 빼오겠다는겨
	//업데이트를 하려면 상품의 기존 값을 알아야함
	//편집 툴에서 기존값이 디폴트값으로 작성되어있어야함
	//인자에 model넣으면 spring에서 자동적으로 model을 생성함
	public String updateProduct(@PathVariable int id, Model model) {
		//id를 바탕으로 하나의 상품을 조회해야해
		Product product = productService.getProductById(id);
		
		model.addAttribute("product", product);
		
		return "updateProduct";
		
	}
	//상품업데이트 등록
	@RequestMapping(value="/productInventory/updateProduct", method=RequestMethod.POST)
	//post 메소드에 들어있는 객체가 Product형식으로 들어와서 Product 형식으로 변수 product로 저장이 된다. //알아서 바인딩!
	//이 메소드는 db에 update하는거임.
	public String updateProductPost(@Valid Product product, BindingResult result ) {
		//에러가 있다면 출력하는것
		if(result.hasErrors()) {
			System.out.println("Form data has some errors");
			//결과에 에러값들을 errors라는 리스트에 저장
			List<ObjectError> errors = result.getAllErrors();
			//errors리스트를 돌면서 product에서 설장한 에레메세지들을 콘솔에 출력
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			//에러가있으면 다시 상품업데이트 페이지로 가게한다.
			return "updateProduct";
		}
		
		
		//System.out.println(product);
		if( !productService.updateProduct(product)) {
			System.out.println("상품 변경 실패했습니당..");
		}
		
		return "redirect:/admin/productInventory";
	}
	
}
	
