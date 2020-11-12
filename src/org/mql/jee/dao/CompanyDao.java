package org.mql.jee.dao;

import java.util.List;

import org.mql.jee.entities.Company;

public interface CompanyDao {
	public Company selectCompany(int id);
	public int insert(Company company);
	public List<Company> companiesList();
	public List<Company> companiesList(int limit);
}
