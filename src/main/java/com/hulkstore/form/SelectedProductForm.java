package com.hulkstore.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author coses
 *
 */
public class SelectedProductForm {
	//validacion del form de carrito
	private int id;
	
	@NotNull(message = "Quantity must be grater than 0")
	@Min(value = 1, message = "Quantity must be grater than 0")
	private Integer quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
