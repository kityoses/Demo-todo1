package com.hulkstore.cart;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulkstore.model.Cart;
import com.hulkstore.service.CartService;

@SpringBootTest
class ModifyCartTest {
	
	private static Logger LOG = LoggerFactory.getLogger(ModifyCartTest.class);

	@Autowired 
	private CartService cartService;
	
	@Test
	void modifyPurchase() {
		LOG.info("---------Modify cart---------");
			Cart cart = cartService.findAll().get(0);
			if(cart == null) {
				LOG.info("Squema cart is empty");
			}
			else {
				Double previousPrice = cart.getTotal();
				cart.setTotal(cart.getTotal()+ 21.00);
				cart.setStatusCart("MODIFIED");
				Cart cartRes = cartService.save(cart);
				assertTrue(cartRes.getTotal() > previousPrice);
				LOG.info("---------Cart modified---------");
			}	
		}
		
}

