package org.mql.jee.business;

import java.util.List;

import org.mql.jee.entities.City;
import org.mql.jee.entities.Company;

public interface CompanyService {
	public int add(City city);
	public int add(Company company);
	public City getCity(int id);
	public Company getCompany(int id);
	public List<City> getCities();
	public List<Company> getCompanies();
	public List<City> getCities(int limit);
	public List<Company> getCompanies(int limit);
}
