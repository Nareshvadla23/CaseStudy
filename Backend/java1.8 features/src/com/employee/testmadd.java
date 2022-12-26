package com.employee;

import java.util.function.Predicate;

public class testmadd {

	public static void main(String[] args) {
		Addition value = (a, b) -> {
			return a + b;
		};

		System.out.println(value.add(2, 5));

		Predicate<Integer> p1 = (a) -> {
			if (a >= 2) {
				return true;
			} else {
				return false;
			}

		};

		System.out.println(p1.test(2));

	}

}
