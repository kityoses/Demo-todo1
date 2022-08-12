package com.hulkstore.service;

import java.util.List;

import com.hulkstore.model.Cart;

/**
 * @author coses
 *
 */
public interface CartService {
	public List<Cart> findAll();
	public Cart save(Cart cart);
	public Cart modify(Cart cart);
	public void deleteById(Integer id);
	public void delete(Cart cart);
}
