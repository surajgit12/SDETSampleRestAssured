package Day01;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryAndPathParamter {
	
	@Test
	public void getMethod() {
		
		//https://reqres.in/api/users?page=2
		RequestSpecification resp =RestAssured.given();
		
		given().baseUri("https://reqres.in")
		.pathParam("mypath1", "api")
    	.pathParam("mypath2", "users")
		.queryParam("page",2)
		
		
		.when().get("https://reqres.in/{mypath1}/{mypath2}")
		
		.then().statusCode(200).log().all();
		
		
		
		
		
	}

}
