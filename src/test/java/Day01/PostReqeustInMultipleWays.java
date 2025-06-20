package Day01;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class PostReqeustInMultipleWays {
	
	@Test(priority=1)
	public void postMethod() {
	HashMap data= new HashMap();
	data.put("name", "savi");
	data.put("location", "PuneQ");
	data.put("phone", "44");
	
	 String coursesArr[] = {"c","c+"};
	 data.put("courses", coursesArr);
	
	
       given()
       .contentType("application/json").body(data)
       .when()
       .post("http://localhost:3000/students")
       .then()
       .statusCode(201)
       .body("name", equalTo("savi"))
       .body("location", equalTo("PuneQ"))
       .body("courses[0]", equalTo("c"))
      .body("courses[1]", equalTo("c+"))
      .header("Content-Type", "application/json")
      .log().all();
       
      }

	@Test(priority=2)
	public void deleteMethod() {
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/6b83")
		
		.then().statusCode(200);
}	
}