package com.visa.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.visa.prj.entity.Customer;

public class CustomerDaoJpaImpl implements CustomerDao {

	@Override
	public Customer customerCheck(String email) {
		EntityManager em=JPAUtil.getEntityManager();
		//String jpql="SELECT c FROM Customer c where c.email=email";
		//Query query=em.createQuery(jpql);
		
				
		return em.find(Customer.class, email);
	}

}
