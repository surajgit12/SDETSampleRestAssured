package Day01;


import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class jsonSchemaValidations {
	
	@Test
	public void jsonSchemaValidationTest() {
		
		
		given()
	
		.when()
		    .get("http://localhost:3000/students")
		
		.then()
		   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemavalidation.json"));
	
		
	}

}
