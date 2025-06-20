package Day01;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class extractJSONDataUsingJsonPath {

	@Test
	public void usingJsonPathValidateJsonData() {

//		Response response = given().when().get("http://localhost:3000/students");
//
//		ResponseBody responsebody = response.body();
//		System.out.println(responsebody.asString());
//
//		JsonPath js = response.jsonPath();
//		String name = js.get("[0].name");
//		System.out.println("name is ---->" + name);
//
//		String courses1 = js.get("[1].courses[1]");
//		System.out.println("courses1 is ---->" + courses1);
//
//		Assert.assertEquals(courses1, "Javascript", "mataches the  courses");
//
//		List<String> courses = response.jsonPath().getList("courses");
//	
//		//System.out.println("courses is ---->" + courses);
//		Assert.assertTrue(courses.contains("selenium"), "'selenium' not found in courses list!");

		given()
		
		.when().
		get("http://localhost:3000/students")
		 .then()
		 .statusCode(200)
	      .time(lessThan(2000L))  // Asserts response time is under 2000ms
		 .body("[0].name", equalTo("suraj"))
		 .body("[0].courses[1]", equalTo("selenium"))
		
	
		 .log().all()
	    .extract()
	    .response();
//		
		
		Response response = given()
				.when()
				    .get("http://localhost:3000/students")
				.then()
				    .statusCode(200)
				    .extract()
				    .response();
		

				// Manual assertions
				assertThat(response.time(), lessThan(2000L));
				assertThat(response.path("[0].name"), equalTo("suraj"));
				assertThat(response.path("[0].courses[1]"), equalTo("selenium"));
	
				/// changes in suraj branch equal
	

				
	}}
		




