package org.mql.jee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.mql.jee.dao.jdbc.DataSource;
import org.mql.jee.dao.jdbc.QueryHandler;
import org.mql.jee.entities.City;

public class CityDaoJDBC implements CityDao{
	private DataSource ds;
	private Connection db;
	private ResultSet resultSet;
	private QueryHandler queryHandler;
	private static final String CITIES = "cities"; 
	public CityDaoJDBC(DataSource ds) {
		setDs(ds);
		db = ds.getConnection();
		queryHandler = new QueryHandler(db);
	}
	public void setDs(DataSource ds) {
		this.ds = ds;
		
	}
	@Override
	public City selectCity(int id) {
		try {
			resultSet = queryHandler.findByLabel(CITIES, "id", id);
			if(resultSet.next()) {
				return getCity(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int insert(City city) {
		try {
			queryHandler.insertCity(city);
			return 1;
		}catch (Exception e) {
			return 0;
		}
		
	}
	@Override
	public List<City> citiesList() {
		List<City> cities = new Vector<City>();
		try {
			resultSet = queryHandler.findAll(CITIES);
			while (resultSet.next()) {
				cities.add(getCity(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cities;
	}
	@Override
	public List<City> citiesList(int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	public City getCity(ResultSet resultSet) throws SQLException {
		return new City(resultSet.getInt("id"), resultSet.getString("name"));
	}
}
