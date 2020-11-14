package org.mql.jee.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.mql.jee.entities.City;

public class CityDaoMemory implements CityDao{
	private Hashtable<Integer, City> cities;
	public CityDaoMemory() {
		init();
	}
	public void init() {
		cities = new Hashtable<Integer, City>();
		cities.put(101, new City(101, "Fès"));
	}
	@Override
	public City selectCity(int id) {
		return cities.get(id);
	}

	@Override
	public int insert(City city) {
		if(selectCity(city.getId()) == null) {
			cities.put(city.getId(), city);
			return 1;
		}
		return 0;
	}

	@Override
	public List<City> citiesList() {
		return new Vector<City>(cities.values());
	}
	@Override
	public List<City> citiesList(int limit) {
		Vector<City> cities = new Vector<City>(this.cities.values());
		Vector<City> citiesLimit = new Vector<City>();
		int k=0;
		while(k<limit) {
			citiesLimit.add(cities.get(k));
			k++;
		}
		return citiesLimit;
	}
}
