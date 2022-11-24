package com.employee;

public class Employee implements Comparable<Employee> {

	private Integer empId;
	private String name;
	private Integer age;
	private String department;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", department=" + department + "]";
	}

	public Employee(Integer empId, String name, Integer age, String department) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.department = department;
	}

	@Override
	public int compareTo(Employee o) {

		return this.age.compareTo(o.age);
	}

}
