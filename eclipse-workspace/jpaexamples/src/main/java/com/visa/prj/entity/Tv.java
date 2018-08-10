package com.visa.prj.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TBL_TV")
//@DiscriminatorValue("tv")
public class Tv extends Item {
	private String screen;

	public Tv() {
		super();
	}

	public Tv(int id, String name, double price, String screen) {
		super(id, name, price);
		this.screen = screen;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}
	
	

}
