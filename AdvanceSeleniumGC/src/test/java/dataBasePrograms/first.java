package dataBasePrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class first {
public static void main(String[] args) throws SQLException {
	//step 1: load /register the database driver
	Driver d=new Driver();
	DriverManager.registerDriver(d);
	//step 2: connect to data base
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	System.out.println("done");
	//step 3: Create sql statement
	Statement s=conn.createStatement();
	//step 4: execute select query and get result
	
	ResultSet r=s.executeQuery("select * from customers");
	while (r.next()) {
		System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\t"+r.getString(5));
		//6362824367 
	}
	//step 5: close the connection
	conn.close();
	
	
}
}
