package org.mql.jee.entities;

public class Company {
	private int id;
	private String name;
	private String email;
	private City city;
	public Company() {
		super();
	}
	public Company(int id, String name, String email, City city) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + "]";
	}
}
