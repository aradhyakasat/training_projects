package com.visa.prj.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.visa.prj.entity.Product;
import com.visa.util.JPAUtil;

public class ProductJPQLClient {

	public static void main(String[] args) {
		/*
		 * JPQL uses class and fields and not table and columns JPQL is case sensitive
		 * about class and attributes JPQL is polymorphic
		 */

		EntityManager em = JPAUtil.getEntityManager();
		// String qry="SELECT p where p.category=?1 and p.price>?2 ";
		/*
		 * String qry="SELECT p where p.category=:cat and p.price>:amt "; TypedQuery
		 * <Product> query=em.createQuery(qry,Product.class); //query.setParameter(1,
		 * "Beverages"); query.setParameter("cat", "Beverages");
		 * query.setParameter("amt", 10.00); 
		 * List <Product>
		 * products=query.getResultList();
		 */
		/*String qry = "SELECT p from Product p";
		TypedQuery<Product> query = em.createQuery(qry, Product.class);
		query.setMaxResults(3);
		query.setFirstResult(10);
		List <Product> products=query.getResultList();
		

		for (Product p : products) {
			System.out.println(p.getProductName() + "" + p.getPrice() + " " + p.getCategory());
		}
		*/
		
		//String qry="SELECT p.category,count(p) from Product p GROUP BY p.category";
		String qry="select p.category, count(*)  from products p group by p.category having count(*)>3";
		//Query query = em.createQuery(qry);
		Query query = em.createNativeQuery(qry);    //to run an sql directly scalar values-query,entities-typedquery
		
		List <Object[]> data=query.getResultList();
		
		for(int i=0;i<data.size();i++) {
			Object[] elems=data.get(i);
			System.out.println(elems[0]+""+elems[1]);
		}
		
		
	}

}
