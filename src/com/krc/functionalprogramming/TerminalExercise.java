package com.krc.functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Some terminal operators:
 * reduce
 * max
 * min
 * forEach
 */

/*
 * Some operations that can be performed on an Optional:
 * get()
 * collect( <COMPARATOR>)
 * orElse(<value instead of null>) - same as get but is also a null check
 */
public class TerminalExercise {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(2, 214, 526, 67, 23, 4213, 13, 246);
		List<Integer> odds = List.of(1, 3, 5, 7, 9);
		Integer a = maxValue(numbers);
		System.out.println(a);
		a = minValue(numbers);
		System.out.println(a);
		List<Integer> evens = getEven(numbers);
		System.out.println(evens);
		List<Integer> squares = squaresOfRange(1, 11);
		System.out.println(squares);

		Integer maxEven = getMaxEvenWithNullCheck(odds);
		System.out.println("Even Value = " + maxEven);
		maxEven = getMaxEvenWithNullCheck(numbers);
		System.out.println("Even Value = " + maxEven);
	}

	private static Integer maxValue(List<Integer> list) {
		return list.stream().max((n1, n2) -> Integer.compare(n1, n2)).get();
	}

	private static Integer minValue(List<Integer> list) {
		return list.stream().min((n1, n2) -> Integer.compare(n1, n2)).get();
	}

	private static List<Integer> getEven(List<Integer> list) {
		return list.stream().filter(i -> i % 2 == 0)
				.collect(Collectors.toList());
	}

	private static List<Integer> squaresOfRange(int n1, int n2) {
		// since IntStream is not an stream of stings we need to use boxed()
		// why??? I don't know
		return IntStream.range(n1, n2).map(n -> n * n).boxed()
				.collect(Collectors.toList());
	}

	private static Integer getMaxEvenWithNullCheck(List<Integer> list) {
		return list.stream().filter(i -> i % 2 == 0)
				.max((n1, n2) -> Integer.compare(n1, n2)).orElse(-1);
	}

}
