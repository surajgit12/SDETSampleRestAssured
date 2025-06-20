package Day01;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.Map;

public class HeadersAndCookies {
	@Test
	public void testGetMethod() {
		
		RequestSpecification res = RestAssured.given();
		res.baseUri("https://reqres.in/api/users/2");
		    
		Response response = res.get();
		
		System.out.println(response.statusCode());
		System.out.println(response.getBody().asPrettyString());
		
		String ContentType =response.getHeader("Content-Type");
		
		System.out.println("**********"+ContentType);
		
		
		
		Headers headervalue =response.headers();
		
		for(Header hd: headervalue) {
			
			System.out.println("Header Key is ---->"  +hd.getName()  +"    " + "Header value is---> "+hd.getValue());
			   Assert.assertEquals(ContentType, "application/json; charset=utf-8", "correct value is");
			
			if(hd.getName()=="Connection") {
				System.out.println(hd.getValue());
			}
		}
		
		Iterator<Header> itr = headervalue.iterator();
		while(itr.hasNext()) {
			
			Header hr = itr.next();
			System.out.println("***" + hr);
		}
		
	}

@Test
public void getCookiesMethod() {
	  
	
    Response res = given()
     
     .when().get("https://www.google.com/");
     
//     .then()
//     .cookie("AEC",  "AVh_V2gYapQW94mPO3POC65KRUKKnve2kn9Kd-itiCnlkX_Xh8P72jZopPU\r\n"
//     		+ "");
		    
                            String value=  res.getCookie("AEC");
    
    
       Map<String,String> cookies =res.cookies();
       
       System.out.println(cookies.keySet());
       
       for(String k: cookies.keySet()) {
    	   
           String cookie_value=  res.getCookie(k);
         System.out.println("test values in cookies"+cookie_value);
    	   
       }
       
       
                                
}  
       
                             
}
