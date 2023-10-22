package com.spring.pojo;

public class Student {

	private String name;
	private int rollno;
	private int marks;
	private String address;
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int rollno, int marks, String address) {
		
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
