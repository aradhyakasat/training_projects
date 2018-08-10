package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalExample2 {
	
	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(34,67,2,78,1,98,23,15,20);
		List<Double> dlist= Arrays.asList(33.12,25.00,34.23);

	
		//iterate(list,(arg)->System.out.println(arg));

		List<Integer> listCopy=new ArrayList<>();
		List<Double> dlistCopy=new ArrayList<>();
		
		//iterate(list,System.out::println);
		copy(listCopy,list);
		copy(dlistCopy,dlist);

	}
	
	
	private static <T> void copy(List <T> list, List<T> listorig) { //High order fn
		for(T i:listorig) {
			list.add(i);
		}
	}

}
