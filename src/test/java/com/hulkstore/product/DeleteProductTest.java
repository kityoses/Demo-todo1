package com.hulkstore.product;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulkstore.model.Product;
import com.hulkstore.service.ProductService;

@SpringBootTest
class DeleteProductTest {
	
	private static Logger LOG = LoggerFactory.getLogger(DeleteProductTest.class);

	@Autowired 
	private ProductService productService;
	
	@Test
	void deleteProduct() {
		LOG.info("---------Delete product---------");
		List<Product> products = productService.findAll();
		if (products == null) {
			LOG.info("Schema Products is empty");
		}
		else {
			Product product = productService.findByName("Traje Capitan America");
			if (product == null) {
				LOG.info("Product doesnt exist on database");
			}
			else {
				productService.delete(product);
				Integer sizeAfter = productService.findAll().size();
				assertTrue(sizeAfter < products.size());
			}
			}	
		LOG.info("---------Product deleted---------");
	}
}
