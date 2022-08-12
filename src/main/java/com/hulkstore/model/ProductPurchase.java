package com.hulkstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author coses
 *
 */
@Entity
public class ProductPurchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "subTotal", nullable = false)
	private Double subTotal;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cartId", nullable=false)
    private Cart cart;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="productId", nullable=false)
    private Product product;	
	
	@Column(name = "category", length = 50, nullable = false)
	private String category;	
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getSubTotal() {
		return subTotal;
	}
	
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
