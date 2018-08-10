package com.visa.prj.client;

import java.util.List;

import com.visa.dao.DaoException;
import com.visa.dao.ProductDao;
import com.visa.dao.ProductDaoJpaImpl;
import com.visa.prj.entity.Product;

public class InsertClient {

	public static void main(String[] args) {
		ProductDao dao = new ProductDaoJpaImpl();

		// Transient state of object p
		Product p = new Product(0, "HP Spectre Laptop", 135000.00, 200);
		Product q = new Product(0, "I Phone", 10000.00, 1000);


		try {
			dao.addProduct(p); // make "p: managed by EntityManager
			dao.addProduct(q);
			List<Product> products = dao.getProducts();
			for (Product prd : products) {
				System.out.println(prd);
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
