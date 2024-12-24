package com.practice.ddtproperty;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readdatafromjson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	JSONParser p1=new JSONParser();
	Object obj=p1.parse(new FileReader("C:\\Users\\admin\\Desktop\\readjson.json"));
	
	JSONObject jsondata=(JSONObject) obj;
	String URL=(String) jsondata.get("url");
	String BROWSER=(String) jsondata.get("browser");
	String USERNAME=(String) jsondata.get("username");
	String PASSWORD= (String) jsondata.get("password");

System.out.println(URL+" "+BROWSER+" "+PASSWORD+" "+USERNAME);
	}

}
