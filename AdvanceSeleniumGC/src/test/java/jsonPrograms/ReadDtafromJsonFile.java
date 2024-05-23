package jsonPrograms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDtafromJsonFile {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	//step 1: parse json physical file into java object
	JSONParser parse=new JSONParser();
	Object obj = parse.parse(new FileReader("C:/Users/RAGHAVENDRA/OneDrive/Desktop/TestYantra/AdvanceAutomation/appcommondata.json"));
	//Step 2:convert java object into jsonobject using downcasting
	JSONObject map=(JSONObject) obj;
	//step 3: get the value from json file using key
	System.out.println(map.get("url"));
	System.out.println(map.get("browser"));
	System.out.println(map.get("usernmae"));
	System.out.println(map.get("password"));
	System.out.println(map.get("timeout"));
}
}
