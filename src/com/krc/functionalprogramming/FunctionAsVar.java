package com.krc.functionalprogramming;

import java.util.List;
import java.util.function.Predicate;

public class FunctionAsVar {

	public static void main(String[] args) {
		// We can store the method of the filter as a predicate (making it a variable
		Integer a = List.of(33, 35, 8, 45, 34, 90).stream()
				.filter(i -> i % 2 == 0)
				.max(Integer::compare).orElse(-1);
		System.out.println(a);

		// functions as variables
		Predicate<? super Integer> evenPredicate = i -> i % 2 == 0;

		// here we set the function as a variable and also had its value returned from a
		// different method
		// too much spaghetti code??
		Predicate<? super Integer> oddPredicate = oddNumberMethod();

		Integer b = List.of(33, 35, 8, 45, 34, 90).stream()
				.filter(evenPredicate).max(Integer::compare)
				.orElse(-1);
		System.out.println(b);

		Integer c = List.of(33, 35, 8, 45, 34, 90).stream()
				.filter(oddPredicate).max(Integer::compare).orElse(-1);
		System.out.println(c);

	}

	private static Predicate<? super Integer> oddNumberMethod() {
		return i -> i % 2 == 1;
	}

}
