package org.mql.jee.business;

import org.mql.jee.dao.CityDaoJDBC;
import org.mql.jee.dao.CityDaoMemory;
import org.mql.jee.dao.CompanyDaoJDBC;
import org.mql.jee.dao.CompanyDaoMemory;
import org.mql.jee.dao.jdbc.MySQLDataSource;
public class BusinessFactoy {
	private static CompanyService companyServiceDefault;
	static {
		// ---------- IN MEMORY DAO
		CityDaoMemory cityDaoMemory = new CityDaoMemory();
		CompanyDaoMemory companyDaoMemory = new CompanyDaoMemory();
		// ---------- JDBC DAO
		CityDaoJDBC cityDaoJDBC = new CityDaoJDBC(MySQLDataSource.getDefaultInstance("db_companies"));
		CompanyDaoJDBC companyDaoJDBC = new CompanyDaoJDBC(MySQLDataSource.getDefaultInstance("db_companies"));
		
		// ------- Service
		companyServiceDefault = new CompanyServiceDefault( cityDaoJDBC, companyDaoJDBC);
	}
	public static CompanyService getCompanyServiceDefault() {
		return companyServiceDefault;
	}
}
