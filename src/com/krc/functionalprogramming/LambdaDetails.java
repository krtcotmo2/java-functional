package com.krc.functionalprogramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class EvenNumPredicateExample implements Predicate<Integer> {
	@Override
	public boolean test(Integer n) {
		// this test returns true if even, false if odd #
		return n % 2 == 0;
	}
}

class ForEachPrintExample implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		System.out.println(t);
	}
}

class SquareMapperExample implements Function<Integer, Integer> {

	@Override
	public Integer apply(Integer t) {
		return t * t;
	}
}

public class LambdaDetails {
	// BEHIND THE SCEENS ON THE LAMBDA
	public static void main(String[] args) {
		//@formatter:off
		/*
		   Filter takes a predicate as a parameter
		 * Stream<T> filter(Predicate<? super T> predicate);
		 *
		   Predicate interface has a test method and it is the only method not defined
		   so the value in the () acts as the method.
		 * boolean test(T t);
		 *
		 *
		 */
		// @formatter:on
		List<Integer> evens = List.of(3, 4, 56, 7, 8, 99, 82, 84).stream()
				.filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(evens);

		// The initial filter does the same thing
		List<Integer> evens2 = evens.stream()
				.filter(new EvenNumPredicateExample())
				.filter(n -> n < 83) // added extra filter so we could see some diff
				.collect(Collectors.toList());
		System.out.println(evens2);


		// @formatter:off
		/*
		   ForEach takes a consumer as a parameter
		 * void forEach(Consumer<? super T> action);
		 *
		   Consumer interface has a accept method and it is the only method not defined
		   so the value in the () acts as the method. It executes any code passed in
		   against the given value
		 * void accept(T t);
		 */
		// @formatter:on
		// IMPLMENTING A FOR EACH PRINT
		List.of(3, 4, 56).stream()
		.forEach(n -> System.out.println(n));

		List.of(3, 4, 56).stream()
		.forEach(new ForEachPrintExample());

		// @formatter:off
		/*
			 map takes a consumer as a parameter
			 R is an Integer in this case
			 T is am Integer in this case
		 * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
		 *
			   Consumer interface has a accept method and it is the only method not defined
			   so the value in the () acts as the method. It executes any code passed in
			   against the given value
		 * void accept(T t);
		 */
		// @formatter:on
		// IMPLMENTING A FOR EACH PRINT
		List.of(3, 4, 9).stream().map(n -> n * n)
		.forEach(n -> System.out.println(n));

		List.of(3, 4, 9).stream().map(new SquareMapperExample())
		.forEach(new ForEachPrintExample());


	}

}
