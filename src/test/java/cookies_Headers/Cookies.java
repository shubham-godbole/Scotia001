package cookies_Headers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {

	@Test
	public void cookies()
	{
	Response res=	given()
		.when()
		.get("https://www.google.com/");
	//get single cookie
		String getC=res.getCookie("NID");        //cookies values are dynamic
		System.out.println("value of cooki is    = "+getC);
		
		//get all cookies
		Map<String,String> allC=res.getCookies();
		for(String c:allC.keySet()) {
			String value=res.getCookie(c);
			System.out.println(c+"  = "+ value);
		}
		
		
	}
}
