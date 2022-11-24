package com.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class TestEmploye1 {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();

		Employee e1 = new Employee(1, "Naresh", 25, "Java");
		Employee e2 = new Employee(2, "rahul", 21, "C++");
		Employee e3 = new Employee(3, "Ramesh", 21, "python");
		Employee e4 = new Employee(4, "suresh", 23, "AWS");
		Employee e5 = new Employee(5, "sathish", 24, "Java");
		Employee e6 = new Employee(6, "sai", 61, "AWS");
		Employee e7 = new Employee(7, "sam", 20, "AWS");
		Employee e8 = new Employee(8, "ram", 19, "Java");
		Employee e9 = new Employee(9, "fam", 18, "AWS");

		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);

		System.out.println("--Max age Employee details--");
		Employee emp = list.stream().max(Comparator.comparing(Employee::getAge)).get();
		System.out.println(emp);
		System.out.println("--Employee details sorted in descending order--");
		list.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);

		Integer sec = list.stream().map(Employee::getAge).sorted().skip(1).findFirst().get();
		System.out.println(sec);
		Integer sec1 = list.stream().map(Employee::getAge).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(sec1);

		System.out.println("---------------------------------------------------");

		list.stream().filter(a -> a.getAge() >= 25).forEach(System.out::println);

		int[] arr = { 1, 1, 2, 3, 4, 4, 5 };

		System.out.println("-1-1-1-1--1-1-1--1-1--1");
		Set<Integer> items = new HashSet<>();

		Arrays.stream(arr).filter(a -> !items.add(a)).forEach(System.out::println);
		
		List<Integer> li =Arrays.asList(1,2,3,2,2,3,4,4);

		
	}

}
