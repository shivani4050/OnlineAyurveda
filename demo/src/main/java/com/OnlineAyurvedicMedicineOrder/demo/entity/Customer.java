package com.OnlineAyurvedicMedicineOrder.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true,nullable = false,length = 100)
	private String email;
	
	@Column(nullable = false,length = 8)
	private String password;
	
	@Column(nullable = false,length = 100)
	private String customerName;//
	
	@OneToMany(targetEntity=Order.class,cascade=CascadeType.ALL)
	@JoinColumn(name="customer_fk",referencedColumnName="id")
	private List<Order> Orders;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Customer(String email, String password,String customerName) {
		super();
		this.email = email;
		this.password = password;
		this.customerName=customerName;
	}
	public Customer(int id, String email, String customerName, String password, List<Order> orders) {
		super();
		this.id = id;
		this.email = email;
		this.customerName = customerName;
		this.password = password;
		Orders = orders;
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public List<Order> getOrders() {
		return Orders;
	}

	public void setOrders(List<Order> orders) {
		Orders = orders;
	}
	public Customer() {
		super();
	}
	
	
}
