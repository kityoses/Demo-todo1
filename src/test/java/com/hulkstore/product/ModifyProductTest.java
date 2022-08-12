package com.hulkstore.product;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulkstore.model.Product;
import com.hulkstore.service.ProductService;

@SpringBootTest
class ModifyProductTest {
	
	private static Logger LOG = LoggerFactory.getLogger(ModifyProductTest.class);

	@Autowired 
	private ProductService productService;
	
	@Test
	void modifyProduct() {
		LOG.info("---------Modify product---------");
		Product product = productService.findByName("Vaso Batman");
		if (product == null) {
			LOG.info("Product doesnt exist on database");
		}
		else {
			product.setName("Vaso Batman nuevo");
			Product res = productService.save(product);
			assertTrue(res.getName().equals(product.getName()));
		}
		
		LOG.info("---------Product Modified---------");		
	}
}
