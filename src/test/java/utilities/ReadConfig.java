package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public  ReadConfig () //Constructor to Load the file
	{
		File f = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}
	//Action Method to get URL from config file
	public String getApplicationURL() {
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getUserName() {
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}

}
