package basicRestAssured;

import org.testng.annotations.Test;
 import static io.restassured.RestAssured.*;
 import static io.restassured.matcher.RestAssuredMatchers.*;
 import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class HTTP_request {
	int id;

	@Test(priority=1)
	void getusers()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
		
		
		;
		
	}
	@Test(priority=2)
	void creatUser()
	{
		HashMap hm=new HashMap();
		hm.put("name","shubham");
		hm.put("job","qa engineer");
		
		id=given()
		.contentType("application/JSON")
		.body(hm)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
	
		
	//	.then()
	//	.statusCode(201);
		
		
		
		
		
	}
	@Test(priority=3,dependsOnMethods = {"creatUser"})
	void updateUser()
	{
		HashMap data =new HashMap();
		data.put("name", "shubh");
		data.put("job", "qa analyst");
		
		given()
		.contentType("application/JSON")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all()
		
		;
	}
	@Test(priority =4)
	void deletUser()
	{
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		
		;
	}
	
}
