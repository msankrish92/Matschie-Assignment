package steps;

import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OpenWeatherSteps {
	
	private RequestSpecification requestSpec;
	private Response response;
	
	@Given("enable logs and set appId and (.*)$")
	public void enableLogs(String cityName) {
		requestSpec = RestAssured.given().log().all()
						.param("q", cityName)
						.and()
						.param("appid", "df2e98029ce5450ae566fc404de48bba")
						.accept(ContentType.JSON);
		
	}
	
	@When("send request as get")
	public void getRequest() {
		response = requestSpec.get();
		response.prettyPrint();
	}
	
	@Then("the status code is {int} and response time less than {int}")
	public void validateStatusCodeAndResponseTime(int code, int time) {
		int statusCode = response.getStatusCode();
		long responseTime = response.getTime();
		System.out.println("respone time:" + responseTime);
		boolean flag = false;
		if(responseTime<time)
		{
			flag = true;
		}

		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(flag, true);
	}
	
	@And("print includes the following")
	public void printContent() {
		JsonPath jsonResponse = response.jsonPath();
		System.out.println("wind speed is " + jsonResponse.getString("wind.speed"));
		System.out.println("maximun temperature is " + jsonResponse.getString("main.temp_max"));
		System.out.println("sunset Time " + jsonResponse.getString("sys.sunset"));
	}
	
	
}
