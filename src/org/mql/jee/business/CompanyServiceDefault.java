package org.mql.jee.business;

import java.util.List;

import org.mql.jee.dao.CityDao;
import org.mql.jee.dao.CompanyDao;
import org.mql.jee.entities.City;
import org.mql.jee.entities.Company;

public class CompanyServiceDefault implements CompanyService{

	private CityDao cityDao;
	private CompanyDao companyDao;
	@Override
	public int add(City city) {
		return cityDao.insert(city);
	}

	@Override
	public int add(Company company) {
		return companyDao.insert(company);
	}

	@Override
	public City getCity(int id) {
		return cityDao.selectCity(id);
	}

	@Override
	public Company geCompany(int id) {
		return companyDao.selectCompany(id);
	}

	@Override
	public List<City> getCities() {
		return cityDao.citiesList();
	}

	@Override
	public List<Company> getCompanies() {
		return companyDao.companiesList();
	}

	@Override
	public List<City> getCities(int limit) {
		return cityDao.citiesList(limit);
	}

	@Override
	public List<Company> getCompanies(int limit) {
		return companyDao.companiesList(limit);
	}

}
