package nutshellstore.testmain;

import nutshellstore.beans.CustomerAddress;
import nutshellstore.beans.CustomerDetails;
import nutshellstore.service.CustomerDataProcessorImpl;

public class TestMain {
	
	public static void main(String[] args) {
		CustomerDetails c1= new CustomerDetails();
		CustomerAddress a1=new CustomerAddress();
		a1.setHouseNumber("12");
		a1.setPincode("700055");
		a1.setStreetNameNumber("abc road");
		c1.setCustomerAddress(a1);
		c1.setCustomerName("Saurabh");
		c1.setCustomerEmail("Saurabh@gmail.com");
		c1.setCustomerPassword("ABCD1234");
		CustomerDataProcessorImpl cdpi = new CustomerDataProcessorImpl();
		//cdpi.createCustomer(c1);
		cdpi.viewCustomers();
		//cdpi.viewCustomerById(1050);
		//cdpi.updateCustomer(c1, 1064);
		//cdpi.deleteCustomer(1065);
		System.out.println("Main Completed");
	}

}

