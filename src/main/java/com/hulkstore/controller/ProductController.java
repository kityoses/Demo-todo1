package com.hulkstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hulkstore.model.Product;
import com.hulkstore.service.ProductService;

/**
 * @author coses
 *
 */
@Controller
public class ProductController {
	

	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getListProducts")
	public String getListProducts(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "/product/productList";
	}

}
