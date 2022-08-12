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
class InsertProductTest {
	
	private static Logger LOG = LoggerFactory.getLogger(InsertProductTest.class);

	@Autowired 
	private ProductService productService;
	
	@Test
	void insertProduct() {
		LOG.info("-----Create product-----");
		Product product = new Product();
		product.setName("Vaso Batman");
		product.setDescription("Vaso Batman");		
		product.setPrice(10.0);
		product.setStock(50);
		product.setStatus("active");
		product.setCategory("DC Comics");
		Product productRes = productService.save(product);
		assertTrue(productRes.getPrice().equals(product.getPrice()));
		LOG.info("-----Finish insert product " + product.getName() + "----");
		
		LOG.info("-----Create Product-----");
		Product product1 = new Product();
		product1.setName("Vaso Superman");
		product1.setDescription("Vaso Superman");		
		product1.setPrice(19.0);
		product1.setStock(20);
		product1.setStatus("active");
		product1.setCategory("DC Comics");
		productService.save(product1);
		LOG.info("-----Finish insert product " + product1.getName() + "----");
		
		LOG.info("-----Create Product-----");
		Product product2 = new Product();
		product2.setName("Guante Thanos");
		product2.setDescription("Guante Thanos");		
		product2.setPrice(200.0);
		product2.setStock(10);
		product2.setStatus("active");
		product2.setCategory("Marvel Studio");
		productService.save(product2);
		LOG.info("-----Finish insert product " + product2.getName() + "----");
		
		LOG.info("-----Create Product-----");
		Product product3 = new Product();
		product3.setName("Traje Capitan America");
		product3.setDescription("Traje Capitan America");		
		product3.setPrice(80.0);
		product3.setStock(20);
		product3.setStatus("active");
		product3.setCategory("Marvel Studio");
		productService.save(product3);
		LOG.info("-----Finish insert product " + product3.getName() + "----");
		
		LOG.info("-----Create Product-----");
		Product product4 = new Product();
		product4.setName("Vaso Robin");
		product4.setDescription("Vaso Robin");		
		product4.setPrice(13.0);
		product4.setStock(53);
		product4.setStatus("active");
		product4.setCategory("DC Comics");
		productService.save(product4);
		LOG.info("-----Finish insert product " + product4.getName() + "----");
		
		//----Uncomment to insert only one product, and comment the rest
		
//		LOG.info("-----Create Product-----");
//		Product product5 = new Product();
//		product5.setName("Gorro spiderman");
//		product5.setDescription("Gorro spiderman");		
//		product5.setPrice(23.0);
//		product5.setStock(23);
//		product5.setStatus("active");
//		product5.setCategory("Marvel");
//		productService.save(product5);
//		LOG.info("-----Finish insert product " + product5.getName() + "----");
	}
}
