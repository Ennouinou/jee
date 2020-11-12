package org.mql.jee.dao;

import java.util.List;

import org.mql.jee.entities.City;

public interface CityDao {
	public City selectCity(int id);
	public int insert(City city);
	public List<City> citiesList();
	public List<City> citiesList(int limit);
}
