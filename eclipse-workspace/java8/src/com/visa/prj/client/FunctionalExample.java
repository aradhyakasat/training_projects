package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Consumer<T>{
	void accept(T obj);
}

@FunctionalInterface
interface Predicate<T>{
	boolean test(T obj);
}

public class FunctionalExample {
	
	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(34,67,2,78,1,98,23,15,20);
		List<Double> dlist= Arrays.asList(33.12,25.00,34.23);

		//iterate(list,(arg)->System.out.println(arg));

		
		iterate(list,System.out::println);
		
		List <Integer> even=filter(list,no -> no%2==0);
		System.out.println(even);

	}
	
	private static void print(List <?> list) {
		//list.add(3);   //no mutation allowed
		for(Object o:list) {
			System.out.println(o);
		}
	}
	
	private static <T> List <T> filter(List <T> list, Predicate<T> pred){
		List <T> copy=new ArrayList<>();
		for(T t:list) {
			if(pred.test(t)) {
				copy.add(t);
			}
		}
		return copy;
	}
	
	private static <T> void iterate(List <? extends T> list, Consumer<? super T> cons) { //High order fn
		for(T i:list) {
			cons.accept(i);
		}
	}

}
