package nutshellstore.service;

import java.util.List;

import nutshellstore.beans.CustomerDetails;

public interface CustomerDataProcessor {

	public long createCustomer(CustomerDetails customerDetails);
	
	public void updateCustomer(CustomerDetails customerDetails, long customerId);
	
	public void deleteCustomer(long customerId);
	
	public List<CustomerDetails> viewCustomers();
	
	public CustomerDetails viewCustomerById(long customerId);
	
}
