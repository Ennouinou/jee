package org.mql.jee.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDataSource extends DataSource {
	public static final String MYSQL_DRIVER="com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIGDGE="jdbc:mysql:";
	
	private static MySQLDataSource mySQLDataSource = new MySQLDataSource("db_companies");
	
	private MySQLDataSource( String host, String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIGDGE, host, source, user, password);
	}
	
	private MySQLDataSource(String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIGDGE,"localhost", source, user, password);
	}
	
	private MySQLDataSource(String source, String user) {
		super(MYSQL_DRIVER, MYSQL_BRIGDGE,"localhost", source, user,"");
	}
	
	private MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIGDGE,"localhost", source, "root","");
	}
	public static MySQLDataSource getDefaultInstance() {
		return mySQLDataSource;
	}
	public Connection getConnection() {
		try {
			// 1. Chargement du driver :
			Class.forName(MYSQL_DRIVER);
			// 2. création de l'URL de connection :
			String url = MYSQL_BRIGDGE + "//" + getHost() +"/"+getSource();
			// 3. Connexion
			Connection db = DriverManager.getConnection(url,getUser(),getPassword());
			System.out.println("Connexion bien établie");
			return db;
		} catch (Exception e) {
			System.out.println("Erreur de connexion : " + e.getMessage());
			return null;
		}
		
	}
	
	
}
