package com.visa.prj.client;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.visa.prj.entity.Book;

public class SetExample {

	public static void main(String[] args) {
//		Set <Book> books=new HashSet<>();
//		Set <Book> books=new TreeSet<>();
Set <Book> books=new TreeSet<>((b1,b2)->Double.compare(b1.getPrice(), b2.getPrice()));
		books.add(new Book(144,"Hibernate in Action",1200.00));
		books.add(new Book(809,"Alchemist",890.00));
		books.add(new Book(713,"Java",890.00));
		books.add(new Book(623,"GOT",900.00));
		books.add(new Book(809,"Alchemist",890.0));
		
		
		
		for(Book b:books) {
			System.out.println(b);
		}
	}

}
