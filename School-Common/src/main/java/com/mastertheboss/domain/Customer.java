package com.mastertheboss.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_email")
	private String customerEmail;
	@Embedded
	private CustomerAddress homeAddress;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="streetName",column=@Column(name="d_street_name")),
	@AttributeOverride(name="houseName",column=@Column(name="d_house_name")),
	@AttributeOverride(name="pinCode",column=@Column(name="d_pin_code")),
	@AttributeOverride(name="state",column=@Column(name="d_state")),
	@AttributeOverride(name="country",column=@Column(name="d_country"))	})
	private CustomerAddress deliveryAddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public CustomerAddress getCustomerAddress() {
		return homeAddress;
	}

	public void setCustomerAddress(CustomerAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public Customer()
	{
		
	}

	public Customer(String customerName, String customerEmail, CustomerAddress homeAddress,CustomerAddress deliveryAddress) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.homeAddress = homeAddress;
		this.deliveryAddress=deliveryAddress;
	}

	public CustomerAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(CustomerAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

}
