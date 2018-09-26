package com.example.MessageProducer;



import javax.persistence.Entity;
import javax.persistence.Id;////////////////////////////////
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity

public class Employee {
	@Id
	private Long id;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}
	public Employee(Long id, String name, int age, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private String name;
	private int age;
	private int salary;
	
	
	
	
}
