package com.amazonaws.lambda.demo;

public class RequestDetails {
	
	private Integer id;
	private String name;
	private String email;
	private String employeer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeer() {
		return employeer;
	}
	public void setEmployeer(String employeer) {
		this.employeer = employeer;
	}
	
	@Override
	public String toString() {
		return "RequestDetails [id=" + id + ", name=" + name + ", email=" + email + ", employeer=" + employeer + "]";
	}
	
	

}
