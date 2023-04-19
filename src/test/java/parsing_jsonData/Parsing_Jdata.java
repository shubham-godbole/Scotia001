package parsing_jsonData;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.scribejava.core.model.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Parsing_Jdata {
//@Test
public void aproch1()
{
	given()
	.when()
	.get("https://reqres.in/api/users?page=2")
	.then()
	.statusCode(200)
	.body("data[1].first_name",equalTo("Lindsay"))
	.header("Content-Type", "application/json; charset=utf-8")
	.log().all();
	
}
 
// by using capturing response and assertion by using jsonpath
@Test
public void respnce() {
	io.restassured.response.Response res =given()
			.contentType("application/JSON")
	.when()
	.get("https://reqres.in/api/users?page=2");
	Assert.assertEquals(res.getStatusCode(), 200) ;
	Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
	Assert.assertEquals(res.jsonPath().get("data[2].last_name"),"Funke");
	
	
}

// by using jsonObject class
@Test
public void jObject() {
	boolean status=false;
	io.restassured.response.Response rs=given()
	.when()
	.get("https://reqres.in/api/users?page=2");
	
	JSONObject jo =new JSONObject(rs.asString());
	int length=jo.getJSONArray("data").length();
Object name=	jo.getJSONArray("data").getJSONObject(1).get("last_name");
System.out.println(name);
System.out.println(length);


//to capyure all the first name from body we have to write for loop
for(int i=0;i<length;i++)
{
	 String first_name =jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
	 System.out.println("first name =  "+first_name);
	 if(first_name.equals("Tobias"))
	 {
		 status=true;
		 
	 }
}
Assert.assertEquals(status, true);
	
}
}
