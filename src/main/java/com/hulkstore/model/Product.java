package com.hulkstore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 * @author coses
 *
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min=2, max=30, message = "El Nombre de tener entre 2 y 30 caracteres")
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@Size(min=2, max=50, message = "La descripcion debe tener entre 2 y 50 caracteres")
	@Column(name = "description", length = 50, nullable = false)
	private String description;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	@Size(min=2, max=30, message = "La categoria de tener entre 2 y 30 caracteres")
	@Column(name = "category", length = 30, nullable = false)
	private String category;
	
    @OneToMany(mappedBy="product")
    private List<ProductPurchase> productPurchases;
    
    @Size(min=2, max=20, message = "El status de tener entre 2 y 20 caracteres")
	@Column(name = "status", length = 20,nullable = false)
	private String status;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public List<ProductPurchase> getProductPurchases() {
		return productPurchases;
	}

	public void setProductPurchases(List<ProductPurchase> productPurchases) {
		this.productPurchases = productPurchases;
	}	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
