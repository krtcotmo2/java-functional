package com.krc.functionalprogramming;

public class Printer {
	static <T> void print(T i) {
		System.out.println(i);
	};

	static <T> int lengthGetter(T i) {
		return String.valueOf(i).length();
	};

	static boolean filterForEven(int i) {
		return i % 2 == 0;
	}

	// NOT REALLU NEEDED SONCE WE COULD DO A METHOD REF ON Integer.compare
	static Integer getMax(int n1, int n2) {
		return Integer.compare(n1, n2);
	}

}
