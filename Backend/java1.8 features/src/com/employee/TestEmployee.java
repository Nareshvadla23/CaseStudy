package com.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestEmployee {

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

		list.stream().forEach(e -> {
			System.out.println(e.toString());
		});

		System.out.println("---------------------");

		Optional<Employee> sorted3 = list.stream().max(Comparator.comparingInt(Employee::getAge));

		if (sorted3.isPresent()) {
			System.out.println(sorted3.get()+"---Max");
		}

		List<Employee> sorted = list.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed())
				.collect(Collectors.toList());

		for (Employee employee : sorted) {
			System.out.println(employee.toString());
		}

		System.out.println("------------------");
		System.out.println("---------------------");

		Optional<Employee> sorted2 = list.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).skip(1)
				.findFirst();

		System.out.println(sorted2.get());

		System.out.println("------------------");
		System.out.println("---------------------");

		List<Employee> sorted1 = list.stream().sorted(Comparator.comparing(Employee::getDepartment))
				.collect(Collectors.toList());

		for (Employee employee : sorted1) {
			System.out.println(employee.toString());
		}

		System.out.println("------------------");

		// filter
		list.stream().filter(e -> e.getAge() >= 25).forEach(e -> {
			System.out.println(e.toString());
		});
		// map
		double ages = list.stream().mapToDouble(Employee::getAge).sum();
		System.out.println(ages);

		// groupBy
		Map<String, List<Employee>> map = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
		System.out.println(map);

		Integer[] arr = { 1, 2, 36, 57, 43, 23, 1 };

		Optional<Integer> max = Arrays.stream(arr).max(Comparator.naturalOrder());
		Optional<Integer> min = Arrays.stream(arr).min(Comparator.naturalOrder());
		Optional<Integer> secondLowest = Arrays.stream(arr).sorted(Comparator.naturalOrder()).skip(1).findFirst();
		Optional<Integer> secondHighest = Arrays.stream(arr).sorted(Comparator.reverseOrder()).skip(1).findFirst();

		System.out.println("Max Number->" + max.get());
		System.out.println("Min Number->" + min.get());
		System.out.println("second lowest Number->" + secondLowest.get());
		System.out.println("second Highest Number->" + secondHighest.get());

		int[] arr1 = { 1, 2, 36, 57, 43, 23, 1 };

		Arrays.stream(arr1).distinct().forEach(System.out::println);

		IntStream stream = IntStream.of(arr1);
		// System.out.println(stream.average().getAsDouble());
		System.out.println(stream.sum());

		List<List<Integer>> flat = new ArrayList<>();
		flat.add(Arrays.asList(1, 2));
		flat.add(Arrays.asList(3, 4));
		flat.add(Arrays.asList(5, 6));
		flat.add(Arrays.asList(7, 8));

		flat.stream().flatMap(e -> e.stream()).forEach(s -> System.out.print(s));

		System.out.println();
	}

}
