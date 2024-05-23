package dataBasePrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ExpectedDataInDatabase {
@Test
public void checkData() throws SQLException {
	String expectedData="Raghu";
	boolean flag=false;
	//register data
	Driver d=new Driver();
	DriverManager.registerDriver(d);
	//give connection to database
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	//create statement
	System.out.println("connected to database successfully");
	Statement s = conn.createStatement();
	//execute query 
	ResultSet res = s.executeQuery("select * from customers;");
while (res.next()) {
	String actData=res.getString(3);
	if (expectedData.equals(actData)) {
		flag=true;
		System.out.println("test case pass"+"\n"+expectedData+" is available");
	}
}
if (flag==false) {
	System.out.println(expectedData+" is not available");
	Assert.fail();
}
//close database
conn.close();
} 
}
