package org.bala.generics;

import java.util.Arrays;
import java.util.List;

public class LowerBoundedWildcard {
	public static void main(String[] arg) {
		printListOfAnyType(Arrays.asList("One", "Two"));
		printListOfAnyType(Arrays.asList(1L, 2L));
	}
	/** lower bounded wild card i.e., can print a list of any type that is a super type of Integer (and of course list of Integer too) */
	public static void printListOfAnyType(List<? super Integer> list) {
		list.forEach(System.out::println);
	}
}
