package basicRestAssured;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PostRequest {
	
	//post request by using hashmap
	
	//@Test
public void ByusingHashmap() 
  {
		HashMap data=new HashMap();
		data.put("name", "shubham");
		data.put("job", "manual tester");
		
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("https://reqres.in/api/users")
	
	
	.then()
	.statusCode(201)
	.body("name", equalTo("shubham"))
	.log().all();
	
	;
	
  }

//post request by using org.json liabrary

//	@Test
	public void ByusingJsonLibry()
	{

		JSONObject data=new JSONObject();
		data.put("name", "shubham");
		data.put("job", "manual tester");
		
	given()
	.contentType("application/json")
	.body(data.toString())
	
	.when()
	.post("https://reqres.in/api/users")
	
	
	.then()
	.statusCode(201)
	.body("name", equalTo("shubham"))
	.body("job", equalTo("manual tester"))
	.log().all();
	}
	
	//post request by using pojo class

	//@Test
	public void ByusingPojoClass()
	{

		PojoClass data = new PojoClass();
		data.setName("shubhu");
		data.setJob("qa");
		
	given()
	.contentType("application/json")
	.body(data)
	
	.when()
	.post("https://reqres.in/api/users")
	
	
	.then()
	.statusCode(201)
	.body("name", equalTo("shubhu"))
	.body("job", equalTo("qa"))
	.log().all();
	}
	
	//post request by using external json file
	
	@Test
	public void ByusingExtrnalJfile() throws IOException
	{

		File f=new File(".\\external_File");
		FileReader fd =new FileReader(f);
		JSONTokener jt =new JSONTokener(fd);
		JSONObject data=new JSONObject(jt);
		
	given()
	.contentType("application/json")
	.body(data.toString())
	
	.when()
	.post("https://reqres.in/api/users")
	
	
	.then()
	.statusCode(201)
	.body("name", equalTo("shubhu"))
	.body("job", equalTo("qa"))
	.log().all();
	}
}
