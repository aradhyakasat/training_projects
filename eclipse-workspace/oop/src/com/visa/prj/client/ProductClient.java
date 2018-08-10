package com.visa.prj.client;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;
import com.visa.prj.util.Utility;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products=new Product[4];
		products[0]=new Mobile(124,"iPhoneX",120000.00,"4G");
		products[1]=new Tv(634,"Onida",3500.00,"CRT");
		products[2]=new Mobile(611,"MotoG",12999.00,"4G");
		products[3]= new Tv(72,"Sony Bravia", 103500.00,"LED"); //upcasting
		
		Utility.sort(products);
		for(Product p:products) {
			System.out.println(p);   //toString()
		}
		
		String[] names= {"Harry", "Peter","Anitha","Angelina"};
		Utility.sort(names);
		for(String name:names)
		{
			System.out.println(name);
		}
		
		printExpensive(products);

	}
	
	private static void printExpensive(Product[] products) {
		for(int i=0;i<products.length;i++) {
			if(products[i].isExpensive()) {    //DYAnamic Binding==>Polymorphism
				System.out.println(products[i].getName()+","+products[i].getPrice());
				printDetails(products[i]);
			}
		}
	}

	private static void printDetails(Product product) {
		Method[] methods= product.getClass().getDeclaredMethods(); //getmethods gives base class methods too
		for(Method m:methods) {
			if(m.getName().startsWith("get")) {
				try {
					Object ret=m.invoke(product);
					System.out.println(ret);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
//	private static void printDetails(Product product) {
//		if (product instanceof Mobile) {
//			Mobile m=(Mobile) product;  // **downcasting typecast required
//			System.out.println(m.getConnectivity());
//		} else if(product instanceof Tv) {
//			Tv t=(Tv) product;
//			System.out.println(t.getScreenType());
//		}
//		
//	}

}
