package Day01;

import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.builder.RequestSpecBuilder;
import java.util.HashMap;

/*
 * given (): -content type , set cookies, add auth, add param, set headers info etc..
 * 
 * when ():-  GET, PUT,POST,DELTE
 * 
 * then ():-Validatte status code, extract response, extract headers cookies & response body
 */
public class HTTPRequests {
	
	@Test
	public void getUser() {
		
//		given()
//		        .pathParam("id", 2)
//		
//		.when()
//		        .get("https://reqres.in/api/users/{id}")
//		        // .get("https://reqres.in/api/users?page=2")
//		
//		.then()
//		    .statusCode(200)
//		  //  .body("page", equalTo(2))
//		    .log().body()
//		    .log().all();
		

	}

}
