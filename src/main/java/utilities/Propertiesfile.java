package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertiesfile {
	//static Properties prop;
 FileInputStream fileinput = null;
 
 public String getProperty(String key) {
	 //1. path
	 String projectPath = System.getProperty("user.dir");
	// String filepath = projectPath+"/properties/application.properties";
	  String filepath = projectPath+"\\properties\\application.properties";
	 //2. Covert the path to object
	 try {
		fileinput = new FileInputStream(filepath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 //3. cover file object into property object
	 
	 Properties prop = new Properties();
	 try {
		prop.load(fileinput);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 //4.prop have a key value pair, just like hashmap

	 String value = prop.getProperty(key);
	 return value;
     	 
 }
}
