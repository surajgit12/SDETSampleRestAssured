package Day01;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class postPojoRq {
	
	@Test(priority=1)
	public void postMethod1() {
		
	PojoPostRequest data= new PojoPostRequest();
	data.setName( "Abdd");
	data.setLocation("AMT");
	data.setPhone("4477");
	
	 String coursesArr[] = {"yy","yy+"};
	 data.setCourses(coursesArr);
	
	
       given()
       .contentType("application/json").body(data)
       .when()
       .post("http://localhost:3000/students")
       .then()

       .statusCode(201)
       .body("name", equalTo("Abdd"))
       .body("location", equalTo("AMT"))
       .body("courses[0]", equalTo("yy"))
      .body("courses[1]", equalTo("yy+"))
      .header("Content-Type", "application/json")
      .log().all();
       
      }

}


