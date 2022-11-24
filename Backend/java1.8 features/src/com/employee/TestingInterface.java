package com.employee;

public class TestingInterface implements TestInterface {

	@Override
	public String getMessage() {

		return "implemented method";
	}
	
	public static void main(String[] args) {
		System.out.println("hello");
		
		TestingInterface test = new TestingInterface();
	
		System.out.println(test.getMessage());
		test.getMessage1();
		TestInterface.getMessage2();
		
		
		
	}

}
