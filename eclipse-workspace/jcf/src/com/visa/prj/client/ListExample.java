package com.visa.prj.client;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.visa.prj.entity.Book;


public class ListExample {
	public static void main(String[] args) {
		List <Book> books= new ArrayList<>();
		
		books.add(new Book(144,"Hibernate in Action",1200.00));
		books.add(new Book(809,"Alchemist",890.00));
		books.add(new Book(713,"Java",890.00));
		books.add(new Book(623,"GOT",900.00));
		
		Collections.sort(books);
		
//		Collections.sort(books, new Comparator(<>) {
//			public int compare(Book b1,Book b2) {
//				return b1.getTitle()-b2.getTitle();
//			}
//	
//		}
//		
	
		Collections.sort(books,(b1,b2)->b1.getTitle().compareTo(b2.getTitle()));
		
		for(Book b:books) {
			System.out.println(b);
		}
	}

}
