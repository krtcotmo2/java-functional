package com.krc.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgramRunner {

	public static void main(String[] args) {
		List<String> letters = List.of("Apple", "Bat", "Cat", "Dog");
		List<Integer> ints = List.of(1, 28, 3, 45, 6);
		printWithFP(letters);
		printWithFP(ints);
		printFPFiltering(letters);
		printFPNumFiltering(ints);
		System.out.println(sumOfNumbers(ints));
		System.out.println(sumOfOddNumbers(ints));
		System.out.println(sumOfEvenNumbers(ints));
		Stream<Integer> a = squareNumbers(ints);
		System.out.println(Arrays.toString(a.toArray()));
		int num = sumOfRangeNumbers(1, 11);
		System.out.println(num);
	}

	private static <T> void printWithFP(List<T> list) {
		System.out.println("List: " + list);
		list.stream().forEach(str -> System.out.println(str));
	}

	private static void printFPFiltering(List<String> list) {
		System.out.println("List: " + list);
		list.stream().filter(str -> str.endsWith("at"))
		.forEach(str -> System.out.println(str));
	}

	private static void printFPNumFiltering(List<Integer> list) {
		System.out.println("List: " + list);
		list.stream().filter(str -> str < 8)
		.forEach(str -> System.out.println(str));
	}

	private static int sumOfNumbers(List<Integer> list) {
		return list.stream().reduce(0,
				(n1, n2) -> n1 + n2);
	}

	private static int sumOfRangeNumbers(int n1, int n2) {
		return IntStream.range(n1, n2).reduce(0, (a, b) -> a + b);
	}

	private static int sumOfOddNumbers(List<Integer> list) {
		return list.stream().filter(n -> n % 2 == 1).reduce(0,
				(n1, n2) -> n1 + n2);
	}

	private static int sumOfEvenNumbers(List<Integer> list) {
		return list.stream().filter(n -> n % 2 == 0).reduce(0,
				(n1, n2) -> n1 + n2);
	}

	private static Stream<Integer> squareNumbers(List<Integer> list) {
		return list.stream().map(n -> n * n);
	}
}
