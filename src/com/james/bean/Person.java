package com.james.bean;

public class Person {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String email;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Person(int id, String username, String password, String sex, String email) {
		super();
		this.id = id;
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
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", email="
				+ email + "]";
	}
}
