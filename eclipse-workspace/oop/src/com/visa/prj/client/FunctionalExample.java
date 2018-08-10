package com.visa.prj.client;

import com.visa.prj.util.Compute;
import java.util.function.BiFunction;
public class FunctionalExample {

	public static void main(String[] args) {
         
		
		BiFunction <Integer, Integer, Double> f=(x,y)->{
			return (double)(x/y);
		};
		
		System.out.println(f.apply(4, 5));
		//old way
		
		Compute <Integer> old =new Compute<Integer>() {    //Anonymous class
			@Override
			public void add(Integer x, Integer y) {
				// TODO Auto-generated method stub
			System.out.println(x+y);	
			}
		};
		
		
		Compute <Integer> c= (Integer x, Integer y) -> {    //lambda expression only applicable for Functional class
			System.out.println(x+y);
		};
		c.add(4, 5);
		
	}

}
