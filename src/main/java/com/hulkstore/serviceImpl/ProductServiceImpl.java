package com.hulkstore.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkstore.model.Product;
import com.hulkstore.repo.ProductRepo;
import com.hulkstore.service.ProductService;

/**
 * @author coses
 *
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product findById(int id) {
		return productRepo.findById(id);
	}
	
	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product modify(Product product) {
		return productRepo.save(product);
	}

	@Override
	public void deleteById(int id) {
		Product product = productRepo.findById(id);
		delete(product);
	}

	@Override
	public void delete(Product product) {
		productRepo.delete(product);
	}

	@Override
	public Product findByName(String name) {
		return productRepo.findByName(name);
	}

}
