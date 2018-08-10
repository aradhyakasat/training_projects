package com.visa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.visa.prj.entity.Product;
import com.visa.util.JPAUtil;

public class ProductDaoJpaImpl implements ProductDao {

	@Override
	public List<Product> getProducts() throws DaoException {
		EntityManager em=JPAUtil.getEntityManager();
		/*
		 * JPQL => Java Persistence Query Language
		 * JPQL uses class name and attributes of class and not table and columns
		 * JPQL is case sensitive, SQL is not case sensitive
		 */
		TypedQuery<Product> query=em.createQuery("SELECT p FROM Product p",Product.class);
		return query.getResultList();
	}

	@Override
	public void addProduct(Product p) throws DaoException {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
			em.persist(p);
		em.getTransaction().commit();

	}

	@Override
	public Product getProduct(int id) throws DaoException {
		EntityManager em=JPAUtil.getEntityManager();
		return em.find(Product.class, id);
	}

	@Override
	public void deleteProduct(int id) throws DaoException {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Product p=em.find(Product.class,id);
		em.remove(p);
		em.getTransaction().commit();
		
	}

	@Override
	public void updateProduct(Product p) throws DaoException {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(p);  //update without dirty check
		em.getTransaction().commit();

	}

	@Override
	public List<Product> getProductsByPrice(double price) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updatePrice() {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
			TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
			List<Product> prds = query.getResultList();
			for(Product  p : prds) {
				if(p.getPrice() > 100000) {
					p.setPrice(p.getPrice() - 5000);
				}
			}
		em.getTransaction().commit();
	}

	@Override
	public void updateProduct(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
