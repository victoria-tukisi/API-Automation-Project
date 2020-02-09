package CIB_DIGITAL_TECH;


import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Resources;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CheckRetrieverBreedIsInListTest extends Resources
{
	String hostname;
	private static Logger log = LogManager.getLogger(CheckRetrieverBreedIsInListTest.class.getName());
	
	@BeforeTest
	public void initializeEnvironment() throws IOException
	{
		hostname = InitializeHost();
		RestAssured.baseURI = prop.getProperty("HOST");
		//log.info("Host is initialized");
	}

	@Test
	public void verifyThatRetrieverBreedDogExists()  
	{		
	    RequestSpecification httpRequest = RestAssured.given();
	    Response response = httpRequest.get("api/breeds/list/all");
	    
	    JsonPath jsonPathEvaluator = response.jsonPath();

	    ArrayList<String> retriever = jsonPathEvaluator.get("message.retriever");
	    //Validation:
	    Assert.assertTrue(retriever.size() > 0);
	    Assert.assertNotNull(retriever, "Retriever exists in list of breeds returned");
	    Assert.assertTrue(!retriever.isEmpty(), "Retriever breed contains sub-breeds.");	    
	    
	    //Display a message in a console to verify that all validation conditions passed 
		System.out.println("Validation is successful, 'retriever' exists!!!");
		log.info("Validation is successful, 'retriever' exists!!!");
		//log.trace("'retriever' exists!!!");
	}
}
