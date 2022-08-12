package com.hulkstore.service;

import java.util.List;

import com.hulkstore.model.Product;

/**
 * @author coses
 *
 */
public interface ProductService {	
	public Product findById(int id);
	public List<Product> findAll();
	public Product save(Product product);
	public Product modify(Product product);
	public void deleteById(int id);
	public void delete(Product product);
	public Product findByName (String name);
}
