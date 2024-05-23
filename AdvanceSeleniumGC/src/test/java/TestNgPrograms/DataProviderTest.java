package TestNgPrograms;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
@Test(dataProvider = "data")
public void CreateContact(String name ,int age , long contact) {
	System.out.println(name+"\t"+age+"\t"+contact);
}
@DataProvider
public Object[][] data() {
	Object[][] arr=new Object[3][3];
	arr[0][0]="raghav";
	arr[0][1]=27;
	arr[0][2]=1234567890l;
	arr[1][0]="chinnu";
	arr[1][1]=26;
	arr[1][2]=2345678999l;
	arr[2][0]="raghav";
	arr[2][1]=27;
	arr[2][2]=0761154321l;
	return arr;
}
}
