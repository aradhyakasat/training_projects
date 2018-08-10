package com.visa.prj.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="TBL_items")
//@DiscriminatorColumn(name="type")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Item {
	@Id                         //for marking as primary key
	//@GeneratedValue(strategy=GenerationType.IDENTITY)  //applicable only for integers
	private int id;
	
	private String name;
	
	private double price;

	public Item(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Item() {
		super();
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

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
