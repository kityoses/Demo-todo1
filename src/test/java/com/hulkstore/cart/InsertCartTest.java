package com.hulkstore.cart;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulkstore.model.Cart;
import com.hulkstore.model.Employee;
import com.hulkstore.model.Product;
import com.hulkstore.model.ProductPurchase;
import com.hulkstore.service.CartService;
import com.hulkstore.service.EmployeeService;
import com.hulkstore.service.ProductService;

@SpringBootTest
class InsertCartTest {
	
	private static Logger LOG = LoggerFactory.getLogger(InsertCartTest.class);

	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired 
	private ProductService productService;
	
	@Autowired 
	private CartService cartService;
	
	@Test
	void insertPurchase() {
		
		LOG.info("---------Create cart---------");
		Cart cart = new Cart();
		Employee employee = employeeService.findByUserName("user");
		if(employee == null) {
			LOG.info("User doesnt exist on database");
		} else {
			cart.setEmployee(employee);
			
			List<Product> products = productService.findAll();
			if (products == null) {
				LOG.info("Schema Products is empty");
			}
			else{
				double total = 0;
				List<ProductPurchase> list = new ArrayList<>();
				for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
					Product p = (Product) iterator.next();
					ProductPurchase prodPurchase = new ProductPurchase();
			        prodPurchase.setName(p.getName());
			        prodPurchase.setProduct(p);
			        prodPurchase.setCart(cart);
			        prodPurchase.setCategory(p.getCategory());
			        prodPurchase.setQuantity(2);
			        prodPurchase.setSubTotal(p.getPrice()* 2);
			        total += p.getPrice()* 2;
					list.add(prodPurchase);
				}
				cart.setProductPurchases(list);
				cart.setTotal(total);
				cart.setStatusCart("FINISHED");
				Integer after  = cartService.findAll().size();							
				cartService.save(cart);
				assertTrue(after < cartService.findAll().size());
				LOG.info("---------Cart created---------");
			}
			
		}
		
	}
}
