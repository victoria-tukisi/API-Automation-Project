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

public class ListSubBreedsForRetrieverTest extends Resources
{
	String hostname;
	private static Logger log = LogManager.getLogger(ListSubBreedsForRetrieverTest.class.getName());
	
	@BeforeTest
	public void initializeEnvironment() throws IOException
	{
		hostname = InitializeHost();
		RestAssured.baseURI = prop.getProperty("HOST");
		//log.info("Host is initialized");
	}

	@Test
	public void getSubBreedsOfRetrieverDog()  
	{
		//Test case 3: Perform an API request to produce a list of sub-breeds for “retriever”. (Diagram 3)
		
	    RequestSpecification httpRequest = RestAssured.given();
	    Response response = httpRequest.get("api/breeds/list/all");

	    JsonPath jsonPathEvaluator = response.jsonPath();

	    ArrayList<String> retriever = jsonPathEvaluator.get("message.retriever");
	    
	    //Verification that 'retriever' has sub-breeds
	    Assert.assertNotNull(retriever, "Retriever exists in list of breeds returned");
	    Assert.assertTrue(!retriever.isEmpty(), "Retriever breed contains sub-breeds.");
	    
	    //Display the list of sub-breeds for 'retriever' dog
	    System.out.println("The list of sub-breeds for 'retriever' are: \n\n" + retriever+ "\n\n");
	    log.info("Listed the of sub-breeds for 'retriever' dog");
	    		
	}
}
