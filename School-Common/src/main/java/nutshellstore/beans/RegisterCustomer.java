package nutshellstore.beans;

import nutshellstore.service.CustomerDataProcessorImpl;

public class RegisterCustomer {

	public void registerCustomer(CustomerDetails c1)
	{
		System.out.println("Register Customers");
		CustomerDataProcessorImpl cdpi = new CustomerDataProcessorImpl();
		cdpi.createCustomer(c1);
	}
	
}
