package com.james.bean;

public class Person {
	private String username;
	private String password;
	private String sex;
	private String email;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String username, String password, String sex, String email) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [username=" + username + ", password=" + password + ", sex=" + sex + ", email=" + email + "]";
	}
	
	
}
