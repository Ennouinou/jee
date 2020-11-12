package org.mql.jee.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import org.mql.jee.entities.Company;

public class CompanyDaoMemory implements CompanyDao{
	private Hashtable<Integer, Company> companies = new Hashtable<Integer, Company>();
	@Override
	public Company selectCompany(int id) {
		return companies.get(id);
	}

	@Override
	public int insert(Company company) {
		if(selectCompany(company.getId()) == null) {
			companies.put(company.getId(), company);
			return 1;
		}
		return 0;
	}

	@Override
	public List<Company> companiesList() {
		return new Vector<Company>(companies.values());
	}

	@Override
	public List<Company> companiesList(int limit) {
		Vector<Company> companies = new Vector<Company>(this.companies.values());
		Vector<Company> companiesLimit = new Vector<Company>();
		int k=0;
		while(k<limit) {
			companiesLimit.add(companies.get(k));
			k++;
		}
		return companiesLimit;
	}

}
