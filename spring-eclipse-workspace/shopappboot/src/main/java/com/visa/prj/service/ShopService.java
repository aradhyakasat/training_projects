package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CustomerDao;
import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service
public class ShopService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	public Product getById(int id) {
		return productDao.findById(id).get();
	}
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public List<Product> getAvailableProducts() {
		return productDao.getAvailableProducts();
	}
	
	@Transactional
	public void addProduct(Product p ) {
		productDao.save(p);
	}
	
	@Transactional
	public void deleteProduct(int id) {
		Product p = productDao.findById(id).get();
		productDao.delete(p);
	}
	
	@Transactional
	public void updateProduct(int id, Product prd) {
		Product p = productDao.getOne(id);
		p.setName(prd.getName());
		p.setPrice(prd.getPrice());
		p.setQuantity(prd.getQuantity());
	}
	
	
	public List<Customer> getCustomers(){
		return customerDao.findAll();
	}
	
	public Customer getById(String email) {
		return customerDao.findById(email).get();
	}

	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.save(customer);
		
	}
	
	@Transactional
	public void deleteCustomer(String email) {
		Customer c=customerDao.findById(email).get();
		customerDao.delete(c);
	}

	@Transactional
	public void updateCustomer(String email, Customer cs) {
		Customer c=customerDao.findById(email).get();
		c.setEmail(cs.getEmail());
		c.setFirstName(cs.getFirstName());
		c.setLastName(cs.getLastName());
		
		}
	
	@Autowired
	private OrderDao orderDao;
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	@Transactional
	public void addOrder(Order order) {
		orderDao.save(order);
	}

	
	
	
	
	
	
}
