package automationTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pageObjects.GetWeatherByCity;
import utilities.Comparator;

public class APIWeatherTest extends TestInitiator{

	Response response;
	
	/**Execute GET API for weather information
	 * @throws IOException
	 */
	@Test(priority=1, enabled=true, groups= "API")
	public void getWeatherInformation() throws IOException
	{
		response = GetWeatherByCity.getByCity();
		logger.info("Verifying status code");
		Assert.assertEquals(response.getStatusCode(), 200, "Response code is 200 OK");
		JsonPath jsonRes = response.jsonPath();
		logger.info("Verifying City name");
		Assert.assertEquals(jsonRes.get("name"), "Delhi");
		double tempapi = jsonRes.getDouble("main.temp");
		logger.info("Temperature is: "+tempapi+"K");
		TestInitiator.temp_api=tempapi;
	}
	
	@Test(priority=2, dependsOnMethods = "getWeatherInformation", enabled=true, groups= "API")
	public void compareAndVariance() throws IOException
	{
		String compareOutput = Comparator.compareTemp(TestInitiator.temp_ui, TestInitiator.temp_api);
		logger.info(compareOutput);
	}

}
