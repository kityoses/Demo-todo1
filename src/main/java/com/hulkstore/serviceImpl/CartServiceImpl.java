package com.hulkstore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkstore.model.Cart;
import com.hulkstore.repo.CartRepo;
import com.hulkstore.service.CartService;

/**
 * @author coses
 *
 */
@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepo cartRepo;

	@Override
	public List<Cart> findAll() {
		return cartRepo.findAll();
	}
	
	@Override
	public Cart save(Cart cart) {
		return cartRepo.save(cart);
	}

	@Override
	public Cart modify(Cart cart) {
		return cartRepo.save(cart);
	}

	@Override
	public void deleteById(Integer id) {
		Cart cart = cartRepo.getReferenceById(id);
		delete(cart);
	}
	
	@Override
	public void delete(Cart cart) {
		cartRepo.delete(cart);
	}
}
