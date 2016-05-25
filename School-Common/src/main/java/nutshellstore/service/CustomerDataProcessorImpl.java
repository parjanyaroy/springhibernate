package nutshellstore.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import nutshellstore.beans.CustomerDetails;

public class CustomerDataProcessorImpl implements CustomerDataProcessor {

	public long createCustomer(CustomerDetails customerDetails) {
		long custId = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			custId = (Long) session.save(customerDetails);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return custId;
	}

	public void updateCustomer(CustomerDetails customerDetails, long customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// CustomerDetails oldCustomerDetail = (CustomerDetails)
			// session.get(CustomerDetails.class,
			// (0<customerId ? customerId : customerDetails.getCustomerId()));
			
			//CustomerDetails oldCustomerDetail = (CustomerDetails) session.get(CustomerDetails.class, customerId);
			CustomerDetails customerDetailsOld = (CustomerDetails) session.get(CustomerDetails.class, customerId);
			customerDetailsOld.updateCustomerDetails(customerDetails,customerDetailsOld.getCustomerId());

			session.update(customerDetailsOld);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void deleteCustomer(long customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CustomerDetails customerDetails = (CustomerDetails) session.get(CustomerDetails.class, customerId);
			session.delete(customerDetails);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public List<CustomerDetails> viewCustomers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<CustomerDetails> customerDetailList = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			customerDetailList = (ArrayList<CustomerDetails>) session.createQuery("FROM CustomerDetails").list();
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customerDetailList;
	}

	public CustomerDetails viewCustomerById(long customerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CustomerDetails customerDetail = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			customerDetail = (CustomerDetails) session.get(CustomerDetails.class, customerId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customerDetail;
	}

}
