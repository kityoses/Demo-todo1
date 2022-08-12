package com.hulkstore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author coses
 *
 */
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min=2, max=30, message = "El Nombre de tener entre 2 y 30 caracteres")
	@Column(name = "firstName", length = 30, nullable = false)
	private String firstName;

	@NotNull
	@Size(min=2, max=30, message = "El Apellido de tener entre 2 y 30 caracteres")
	@Column(name = "lastName", length = 30, nullable = false)
	private String lastName;
	
	@NotNull
	@Size(min=2, max=30, message = "El Email de tener entre 2 y 30 caracteres")
	@Column(name = "email", length = 30, nullable = false)
	private String email;

	@NotNull
	@Size(min=4, max=10, message = "El Usuario de tener entre 4 y 10 caracteres")
	@Column(name = "userName" , length = 10, nullable = false)
	private String userName;
	
	@NotNull
	@Size(min=4, max=100, message = "La contraseña de tener entre 4 y 100 caracteres")
	@Column(name = "password", length = 100, nullable = false)
	private String password;
	
	@Size(min=2, max=20, message = "El status de tener entre 2 y 20 caracteres")
	@Column(name = "status", length = 20, nullable = false)
	private String status;
	
	
    @OneToMany(mappedBy="employee")
    private List<Cart> carts;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
}
