package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
public void getDbConnection(String url,String username,String password) throws SQLException {
	try {
	Driver d=new Driver();
	DriverManager.registerDriver(d);
	 con=DriverManager.getConnection(url,username,password);
	}catch (Exception e) {
		// TODO: handle exception
	}
}
public void getDbConnection() {
	try {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public void closeConnection() {
	try {
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
	}
}
public ResultSet executeSelectQuery(String query) throws SQLException {
ResultSet r=null;
	try {
	Statement s=con.createStatement();
			r=s.executeQuery(query);
} catch (Exception e) {
	// TODO: handle exception
}
	return r;
}
public int ececuteNonSelectQuery(String query) {
	int result=0;
	try {
		Statement s=con.createStatement();
		result=s.executeUpdate(query);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result;
}
}
