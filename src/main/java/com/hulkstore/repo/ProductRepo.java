package com.hulkstore.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulkstore.model.Product;

/**
 * @author coses
 *
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	public Product findById(int id);	
	public Product findByName(String name);

}
