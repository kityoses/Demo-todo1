package com.hulkstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 * @author coses
 *
 */
@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "total", nullable = false)
	private Double total;
    
	@Size(min=2, max=20, message = "El statusCart de tener entre 2 y 20 caracteres")
	@Column(name = "statusCart",length = 20, nullable = false)
	private String statusCart;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employeeId", nullable=false)
    private Employee employee;	
	
    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL)
    private List<ProductPurchase> productPurchases;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getStatusCart() {
		return statusCart;
	}
	
	public void setStatusCart(String statusCart) {
		this.statusCart = statusCart;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<ProductPurchase> getProductPurchases() {
		return productPurchases;
	}

	public void setProductPurchases(List<ProductPurchase> productPurchases) {
		this.productPurchases = productPurchases;
	}
}
