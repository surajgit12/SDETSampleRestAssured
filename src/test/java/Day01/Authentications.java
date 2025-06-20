package Day01;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Authentications {

	@Test
	public void BasicAuth() {

		given()
		       //   .auth().basic("postman", "password")
		        //  .auth().digest("postman", "password")
		          .auth().preemptive().basic("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then()
				.statusCode(200)
			    .body("authenticated", equalTo(true))
				.log().all();
		

		// third line by suraj feature branch

		// first changes.
		// second  changes in
		//thried line added by master
		
		// 12222222222222222 feature
		

	}

}
