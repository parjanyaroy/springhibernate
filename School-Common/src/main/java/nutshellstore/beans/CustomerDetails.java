package nutshellstore.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
	@SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
	@Column(name = "customer_id")
	private long customerId;
	@Column(name = "customer_role")
	private String customerRole;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_email")
	private String customerEmail;
	@Column(name = "customer_password")
	private String customerPassword;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public CustomerDetails(long customerId, String customerName, String customerEmail, String customerPassword,
			String mobile, Date dateOfBirth, CustomerAddress customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.mobile = mobile;
		this.dateOfBirth = dateOfBirth;
		this.customerAddress = customerAddress;
	}

	// Used while updating an existing customer with new data
	public void updateCustomerDetails(CustomerDetails customerDetails,long oldCustomerId) {
		this.customerId = oldCustomerId;
		this.customerName = customerDetails.getCustomerName();
		this.customerEmail = customerDetails.getCustomerEmail();
		this.customerPassword = customerDetails.getCustomerPassword();
		this.mobile = customerDetails.getMobile();
		this.dateOfBirth = customerDetails.getDateOfBirth();
		this.customerAddress = customerDetails.getCustomerAddress();
	}

	public CustomerDetails() {

	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void Sanmay(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerRole() {
		return customerRole;
	}

	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}

	/*
	 * CREATE SEQUENCE "NUTSHELLSTORE"."ADDRESS_ID_SEQ" MINVALUE 10000 MAXVALUE
	 * 20000 INCREMENT BY 1 START WITH 10001 CACHE 20 NOORDER NOCYCLE ;
	 */

}
