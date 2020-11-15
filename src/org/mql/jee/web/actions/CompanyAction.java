package org.mql.jee.web.actions;

import java.util.List;

import org.mql.jee.business.BusinessFactoy;
import org.mql.jee.business.CompanyService;
import org.mql.jee.entities.City;
import org.mql.jee.entities.Company;

public class CompanyAction {
	//--------- Action properties
	private CompanyService companyService;
	private Company company;
	private List<Company> companies;
	private City city;
	private List<City> cities;
	//--------- Action constructor
	public CompanyAction() {
		companyService = BusinessFactoy.getCompanyServiceDefault();
	}
	//--------- Action Méthodes 
	public String listCompanies() {
		companies = companyService.getCompanies();
		return "listCompanies";
	}
	public String addCompany() {
		cities = companyService.getCities();
		return "addCompany";
	}
	public String saveCompany() {
		companyService.add(company);
		return "showCompany";
	}
	public String listCities() {
		cities = companyService.getCities();
		return "listCities";
	}
	public String addCity() {
		return "addCity";
	}
	public String showCity() {
		return "showCity";
	}
	public String saveCity() {
		companyService.add(city);
		return "showCity";
	}
	public String showCompany() {
		return "showCompany";
	}
	//--------- Others:
	public City getChoosedCity(int id) {
		return companyService.getCity(id);		
	}
	public Company getChoosedCompany(int id) {
		return companyService.getCompany(id);		
	}
	
	//--------- Setters and Getters
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
	
	
	
	
}
