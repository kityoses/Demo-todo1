package com.hulkstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulkstore.model.Cart;

/**
 * @author coses
 *
 */
@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
}
