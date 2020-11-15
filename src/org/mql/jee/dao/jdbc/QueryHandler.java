package org.mql.jee.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mql.jee.entities.City;
import org.mql.jee.entities.Company;

public class QueryHandler {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public QueryHandler(Connection connection) {
		this.connection = connection;
	}

	public ResultSet findByLabel(String tableName, String label, int value) throws SQLException {
		preparedStatement = connection.prepareStatement("select * from " + tableName + " where " + label + " =?;");
		preparedStatement.setObject(1, value);
		resultSet = preparedStatement.executeQuery();

		return resultSet;
	}
	public ResultSet findAll(String tableName) throws SQLException {
		preparedStatement = connection.prepareStatement("select * from " + tableName +";");
		resultSet = preparedStatement.executeQuery();
		return resultSet;
	}
	public void insertCity(City city) throws SQLException {
		preparedStatement = connection.prepareStatement("insert into cities values (?,?);");
		preparedStatement.setInt(1, city.getId());
		preparedStatement.setString(2, city.getName());
		preparedStatement.executeUpdate();
	}
	public void insertCompany(Company company) throws SQLException {
		preparedStatement = connection.prepareStatement("insert into companies values (?,?,?,?);");
		preparedStatement.setInt(1, company.getId());
		preparedStatement.setString(2, company.getName());
		preparedStatement.setString(3, company.getEmail());
		preparedStatement.setInt(4, company.getCity().getId());
		preparedStatement.executeUpdate();
	}
}
