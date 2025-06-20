package Day01;


import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;


public class parsingjsonresponseData {
	
	
	@Test
	public void getMethodJsonData() {
		
//		given()
//		
//		.when()
//		 .get("http://localhost:3000/students")
//		
//		.then()
//	     .header("Content-Type", "application/json")
//	    
//	     .body("[3].courses[0]", equalTo("APIAutomation"))
//	     .statusCode(200).log().all();
//		
		
		
		Response res = given()

				.when().get("http://localhost:3000/students");
		
	 JSONObject js = new JSONObject();
		JSONArray ja = new JSONArray(res.asString());

		// Iterate through the students array and print name
		for (int i = 0; i < ja.length(); i++) {
		    String bookTitle = ja.getJSONObject(i).get("courses").toString();
		    System.out.println(bookTitle);
		}
			    
			     
		
		
		
	}

}
