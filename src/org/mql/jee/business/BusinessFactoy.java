package org.mql.jee.business;

import org.mql.jee.dao.CityDaoMemory;
import org.mql.jee.dao.CompanyDaoMemory;

public class BusinessFactoy {
	private static CompanyService companyServiceDefault;
	static {
		companyServiceDefault = new CompanyServiceDefault(new CityDaoMemory(), new CompanyDaoMemory());
	}
	public static CompanyService getCompanyServiceDefault() {
		return companyServiceDefault;
	}
}
