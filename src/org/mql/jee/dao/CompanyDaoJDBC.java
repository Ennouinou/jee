package org.mql.jee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.mql.jee.dao.jdbc.*;
import org.mql.jee.entities.Company;


public class CompanyDaoJDBC implements CompanyDao{
	private DataSource ds;
	private Connection db;
	private ResultSet resultSet;
	private QueryHandler queryHandler;
	private static final String COMPANIES = "companies";
	CityDaoJDBC cityDaoJDBC;
	public CompanyDaoJDBC(DataSource ds) {
		setDs(ds);
		db = ds.getConnection();
		queryHandler = new QueryHandler(db);
		cityDaoJDBC = new CityDaoJDBC(ds);
	}
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public Company selectCompany(int id) {
		try {
			resultSet = queryHandler.findByLabel(COMPANIES, "id", id);
			if(resultSet.next()) {
				return getCompany(resultSet);
			}
		} catch (Exception e) {

		}
		return null;
	}
	@Override
	public int insert(Company company) {
		try {
			queryHandler.insertCompany(company);
			return 1;
		}catch (Exception e) {
			return 0;
		}
		
	}
	@Override
	public List<Company> companiesList() {
		List<Company> companies = new Vector<Company>();
		try {
			resultSet = queryHandler.findAll(COMPANIES);
			while (resultSet.next()) {
				companies.add(getCompany(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companies;
	}
	@Override
	public List<Company> companiesList(int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	public Company getCompany(ResultSet resultSet) throws SQLException {
		return new Company(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("email"),cityDaoJDBC.selectCity(resultSet.getInt("id_city")));

	}
}
