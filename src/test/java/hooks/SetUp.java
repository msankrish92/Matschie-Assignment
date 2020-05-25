package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class SetUp {
	
	@Before
	public void beforeSetUp() throws IOException {
		Properties pr = new Properties();
		FileInputStream fl = new FileInputStream("./src/test/resources/config.properties");
		pr.load(fl);
//		System.out.println(pr.getProperty("server") + pr.getProperty("resources"));
		RestAssured.baseURI = pr.getProperty("server") + pr.getProperty("resources");
	}
	
}
