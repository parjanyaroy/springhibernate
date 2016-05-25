package nutshellstore.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ADDRESS")
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
	@SequenceGenerator(name = "address_id_seq", sequenceName = "address_id_seq", allocationSize = 1)
	@Column(name = "address_id")
	private long addressId;
	@Column(name = "house_number")
	private String houseNumber;
	@Column(name = "street_name_number")
	private String streetNameNumber;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "state")
	private String state;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@OneToOne
	@PrimaryKeyJoinColumn
	private CustomerDetails customerDetails;
	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetNameNumber() {
		return streetNameNumber;
	}
	public void setStreetNameNumber(String streetNameNumber) {
		this.streetNameNumber = streetNameNumber;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
