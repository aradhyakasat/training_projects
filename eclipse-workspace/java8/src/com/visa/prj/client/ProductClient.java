package com.visa.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.visa.prj.entity.Product;

public class ProductClient {

	private static boolean isMobile(Product p) {
		return p.getCategory().equals("mobile");
	}

	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1230, "iPhone X", 120000.00, "mobile"));
		products.add(new Product(412, "Onida", 3500.00, "tv"));
		products.add(new Product(734, "Oppo", 6000.00, "mobile"));
		products.add(new Product(652, "Logitech", 450.00, "computer"));

		/*
		 * products.stream() .filter(p->p.getCategory().equals("mobile"))
		 * .map(p->p.getName()) .forEach(System.out::println); }
		 */
		products.stream().filter(ProductClient::isMobile).map(p -> p.getName()).forEach(System.out::println);

		System.out.println("*************");

		List<Product> mobiles = products.stream() // Useful for collecting andf then sending to say UI than printing on
													// the server side directly
				.filter(ProductClient::isMobile).collect(Collectors.toList());

		mobiles.forEach(m -> {
			System.out.println(m.getName() + "," + m.getCategory() + "," + m.getPrice());
		});

		System.out.println("*************");

		double total = products.stream().map(p -> p.getPrice()).reduce(0.0, (v1, v2) -> v1 + v2);

		System.out.println(total);

		Map<String, List<Product>> productMap = products.stream().collect(Collectors.groupingBy(p -> p.getCategory()));

		productMap.forEach((k, v) -> {
			System.out.println("Category:" + k);
			v.forEach(System.out::println);
		});

	}

}