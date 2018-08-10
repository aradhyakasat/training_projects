package com.visa.prj.util;

@FunctionalInterface
public interface Compute<T> {
	void add(T x, T y);
//Functional interface can have any no. of default methods
	default void sub(T x, T y)
	{
		System.out.println("SomeCode");;
	}
}
