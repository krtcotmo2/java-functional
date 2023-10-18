package com.krc.functionalprogramming;

import java.util.List;


public class MethodRefRunner {

	// to create your own create the method
	public static void print(Integer t) {
		System.out.println(t);
	}

	public static void main(String[] args) {

		List.of("Animal", "Bear", "Cat", "Dog", "Elephant").stream()
		.map(s -> s.length()).forEach(s -> System.out.println(s));
		System.out.println();
		System.out.println();

		// Shortcut for the method
		List.of("Animal", "Bear", "Cat", "Dog", "Elephant").stream()
		.map(s -> s.length()).forEach(System.out::println);

		// to use your own call it with the class
		// same file
		List.of("Animal", "Bear", "Cat", "Dog", "Elephant").stream()
		.map(s -> s.length()).forEach(MethodRefRunner::print);

		// different file
		List.of("Animal", "Bear", "Cat", "Dog", "Elephant").stream()
		.forEach(Printer::print);

		// Replace the length and the print out
		List.of("Animal", "Bear", "Cat", "Dog", "Elephant").stream()
		.map(Printer::lengthGetter).forEach(MethodRefRunner::print);
		System.out.println();
		System.out.println();

		// New sample
		Integer a = List.of(33, 35, 8, 45, 34, 90).stream()
				.filter(i -> i % 2 == 0)
				.max((n1, n2) -> Integer.compare(n1, n2)).orElse(-1);
		System.out.println(a);

		Integer b = List.of(33, 35, 8, 45, 34, 90).stream()
				.filter(Printer::filterForEven).max(Printer::getMax).orElse(-1);
		System.out.println(b);
		// not that we used the method ref on Integer.compare
		Integer allOdds = List.of(33, 35, 45, 35, 91).stream()
				.filter(Printer::filterForEven).max(Integer::compare)
				.orElse(-1);
		System.out.println(allOdds);

	}

}
