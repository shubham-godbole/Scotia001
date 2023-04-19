package cookies_Headers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Header {
	@Test
	public void header()
	{
		given()
		.when()
		.get("https://www.google.com/")
		.then()
	
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.header("Cache-Control", "private, max-age=0")
		
		.header("Content-Encoding", "gzip")
		.log().headers();
		
	}
	@Test
	public void getCookies() {
		Response resp=given()
		.when()
		.get("https://www.google.com/");
		String hdr=resp.getHeader("Content-Type");
		System.out.println("value of header === "+hdr);
		
	Headers hd=	resp.getHeaders();
	for(io.restassured.http.Header h: hd)
	{
		String name=h.getName();
		String value=h.getValue();
		System.out.println(name+"  = "+value);
	}
	}

}
