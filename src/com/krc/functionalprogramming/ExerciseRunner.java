package com.krc.functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExerciseRunner {

	public static void main(String[] args) {
		List<String> letters = List.of("Apple", "Bat", "Cat", "Dog");
		printSqrRange(1, 11);
		toLowerCase(letters);
		List<String> a = lengthOf(letters);
		System.out.println(a);
	}

	private static void printSqrRange(int n1, int n2){
		IntStream.range(n1, n2).map(n -> n * n)
		.forEach(n -> System.out.println(n));
	}

	private static void toLowerCase(List<String> list) {
		list.stream().map(n -> n.toLowerCase())
		.forEach(n -> System.out.println(n));
	}

	private static List<String> lengthOf(List<String> list) {
		return list.stream()
				.map(n -> "Length of " + n + " is " + n.length())
				.collect(Collectors.toList());
	}
}
