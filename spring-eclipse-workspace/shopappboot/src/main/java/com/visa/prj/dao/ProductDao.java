package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visa.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	
	@Query("from Product p where p.quantity>0")
	List<Product> getAvailableProducts();
	
	//functions starting with findBy class parameters with and & or works automatically

}
