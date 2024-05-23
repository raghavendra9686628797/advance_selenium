package dataBasePrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertdataTODatabase {

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
				int res=s.executeUpdate("insert into customers values(11,011,'Chinnu',8000000,'18-08-08');");
				System.out.println(res);
		
		//step 5: close the connection
		conn.close();
		
	}

}
