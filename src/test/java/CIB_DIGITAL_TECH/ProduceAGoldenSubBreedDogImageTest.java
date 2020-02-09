package CIB_DIGITAL_TECH;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ProduceAGoldenSubBreedDogImageTest extends Resources
{
	private static Logger log = LogManager.getLogger(ProduceAGoldenSubBreedDogImageTest.class.getName());
	String hostname;
	
	@BeforeTest
	public void initializeEnvironment() throws IOException
	{
		hostname = InitializeHost();
		RestAssured.baseURI = prop.getProperty("HOST");
	}
	
	@Test
	public void getGoldenSubBreedDog() 
	{
		//Test case 4: Perform an API request to produce a random image / link for the sub-breed “golden” (Diagram 4)
		
	    RequestSpecification httpRequest = RestAssured.given();
	    Response response = httpRequest.get("api/breed/retriever/golden/images/random");
	    
	    JsonPath jsonPathEvaluator = response.jsonPath();	    
	    
	    Assert.assertNotNull(jsonPathEvaluator.get("message"));
	    
	    System.out.println("The extracted image / link for sub-breed dog 'golden' is: \n\n"+jsonPathEvaluator.get("message"));	
		
	    log.info("Successfully extracted 'golden' sub-breed dog");
	}
}
