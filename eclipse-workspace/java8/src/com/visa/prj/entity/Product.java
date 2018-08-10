package com.visa.prj.entity;

public class Product{
	private int id;
	private String name;
	private double price;
	private String Category;
	
	public Product() {
	}
	
	public Product(int id, String name, double price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.Category = category;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/*
	public boolean isExpensive() {
		return false
	}
	*/
	
	//public abstract boolean isExpensive();
	
	//@Override
//	public int compareTo(Product p) {
//		//Product p=(Product) o; eliminated using generic
//		if(this.price>p.price) {
//			return 1;
//		} else if(p.price>this.price) {
//			return -1;
//		}
//		return 0;
//	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
