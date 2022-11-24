package com.employee;

public interface TestInterface {
	
	
	public String getMessage();
	public default  String getMessage1() {
		return "hello";
	}
	public static String getMessage2() {
		return "hii";
	}

}
