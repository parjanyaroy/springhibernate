package com.mastertheboss.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.mastertheboss.domain.Customer;
import com.mastertheboss.domain.CustomerAddress;
import com.mastertheboss.domain.Order;

public class OrderTest {
	@PersistenceContext
	private static EntityManager entityManager;

	public OrderTest(EntityManager manager) {
		this.entityManager = manager;
	}

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.innotrekker.api.jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
			/** Uncomment The Following to Persist Entity */
			 entityManager.getTransaction().begin();
			entityManager.persist(new Order("Gift wrapped " + 0 + "", new Date(),95.0));
			CustomerAddress homeAddress= new CustomerAddress("Jessore", "BSAS", "700055", "West Bengal", "India");
			CustomerAddress deliveryAddress= new CustomerAddress("Jubilee Enclave", "Phase 3 ,Hyd Campus", "5000081", "Telengana", "India");
			Customer cust = new Customer("Parjanya Roy", "parjanyaroy@gmail.com",homeAddress,deliveryAddress);
			entityManager.persist(cust);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Order> results = entityManager.createQuery("Select o from Order o", Order.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		// Fetching order using named queries
		entityManager = entityManagerFactory.createEntityManager();
		List<Order> allOrderList= getAllOrders(entityManager);
		List<Order> selectedOrderList= getAllOrdersByComment("Gift wrapped 1",entityManager);
		entityManagerFactory.close();
	}

	public static List<Order> getAllOrders(EntityManager entityManager2) {
		List<Order> orders = entityManager2.createNamedQuery("getAllOrders", Order.class)
				.getResultList();
		return orders;
	}

	
	public static List<Order> getAllOrdersByComment(String comment, EntityManager entityManager2) {
		List<Order> orders = entityManager2.createNamedQuery("getAllOrdersByComment", Order.class)
				.setParameter(1, comment).getResultList();
		return orders;
	}

}
