package org.bala.generics;

import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcard {
	public static void main(String[] arg) {
		printListOfAnyType(Arrays.asList(1.1d, 2.2d));
		printListOfAnyType(Arrays.asList(1L, 2L));
	}
	/** upper bounded wild card i.e., can print a list of any type that extends Number (and of course list of Number too) */
	public static void printListOfAnyType(List<? extends Number> list) {
		list.forEach(System.out::println);
	}
}
