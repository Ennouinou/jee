package org.mql.jee.web;

import javax.servlet.http.HttpServletRequest;

import org.mql.jee.entities.City;
import org.mql.jee.entities.Company;

public class ParametersResolver {
	private HttpServletRequest request;
	public ParametersResolver(HttpServletRequest request) {
		this.request = request;
	}
	public String get(String name) {
		return request.getParameter(name);
	}
	public int getInt(String name) {
		try {
			return Integer.parseInt(request.getParameter(name));
		}
		catch (Exception e) {
			return -1;
		}
	}
	public Company getCompany(City city) {
		return new Company(getInt("id"), get("name"), get("email"), city);
	}
	public City getCity() {
		return new City(getInt("id"), get("name"));
	}
}
