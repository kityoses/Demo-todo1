package com.hulkstore.cart;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulkstore.model.Cart;
import com.hulkstore.service.CartService;

@SpringBootTest
class DeleteCartTest {
	
	private static Logger LOG = LoggerFactory.getLogger(DeleteCartTest.class);

	@Autowired 
	private CartService purchaseService;
	
	@Test
	void deletePurchase() {
		LOG.info("---------Delete cart---------");
		List<Cart> purchases = purchaseService.findAll();
		if(purchases.isEmpty()) {
			LOG.info("Squema cart is empty");
		}
		else {
			Cart purchase = purchases.get(0);
			purchaseService.delete(purchase);
			Integer sizeAfter = purchaseService.findAll().size();
			assertTrue(sizeAfter < purchases.size());
			LOG.info("---------Cart deleted---------");
		}
		
	}
}
