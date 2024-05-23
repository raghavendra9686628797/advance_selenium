package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class First {

	public static void main(String[] args) throws IOException {
		// step:1 get the java representation object of physical file
		FileInputStream fis=new FileInputStream("C:/Users/RAGHAVENDRA/OneDrive/Desktop/TestYantra/AdvanceAutomation/DDTproperty.properties");
		//step:2 using property class load all the keys
		Properties p=new Properties();
		p.load(fis);
		//step:3 get the values based on key
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));

	}

}
