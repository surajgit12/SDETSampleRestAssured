package Day01;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class UsingExternalFilePostRequest {

	@Test
	public void postMethod2() throws FileNotFoundException {

		File f = new File(".\\newapi.json");
//		FileReader fl = new FileReader(f);
//		JSONTokener jt = new JSONTokener(fl);
//		JSONObject data = new JSONObject(jt);

		  given().contentType("application/json").body(f)
		  .when().post("http://localhost:3000/students")
				.then().statusCode(201).body("students[0].name", equalTo("suraj"))
				.body("students[0].location", equalTo("Pune"))
				.body("students[0].courses[0]", equalTo("java"))
				.body("students[0].courses[1]", equalTo("selenium"))
				.header("Content-Type", "application/json").log()
				.all();

	}

}
