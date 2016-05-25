package com.mastertheboss.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerAddress {
	@Column(name = "street_name")
	private String streetName;
	@Column(name = "house_name")
	private String houseName;
	@Column(name = "pin_code")
	private String pinCode;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;

	public CustomerAddress()
	{
		
	}
	
	public CustomerAddress(String streetName, String houseName, String pinCode, String state, String country) {
		super();
		this.streetName = streetName;
		this.houseName = houseName;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
	}

}
