package cn.kkl.mail.testFreemarker.pojo;

public class Student {
	
	private String name;
	private int age;
	private int id;
	private char gender;
	private String address;
	
	public Student() {
		super();
	}
	
	public Student(String name, int age, int id, char gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.gender = gender;
		this.address = address;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
