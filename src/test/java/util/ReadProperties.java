package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public static String getprop(String filename,String propname) throws FileNotFoundException, IOException{
		Properties props=new Properties();
		//props.load(new FileInputStream("./target/test-classes/element/"+filename+".properties"));
		props.load(new FileInputStream("D:/myeclipse01/selenium08/src/test/java/element/"+filename+".properties"));
		String str=props.getProperty(propname);
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
