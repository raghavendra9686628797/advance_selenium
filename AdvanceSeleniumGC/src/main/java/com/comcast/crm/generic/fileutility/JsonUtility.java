package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws IOException, ParseException {
	FileReader file=new FileReader("./configAppData/appcommondata.json");
	JSONParser jp=new JSONParser();
	Object obj = jp.parse(file);
	JSONObject jobj=(JSONObject) obj;
	String data = (String) jobj.get(key);
	return data;
}
}
