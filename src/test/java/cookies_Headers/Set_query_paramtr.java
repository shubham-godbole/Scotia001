package cookies_Headers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Set_query_paramtr {
@Test
public void set_queryP()
{
	
	//       https://reqres.in/api/users?page=2"
	// https://reqres.in     server
	// /api/users            path parameter
	//?page=2"              query parameter 
	
	given()
	.pathParam("myPath","users")
	.queryParam("page",2)
	.queryParam("id", 5)
	
	.when()
	.get("https://reqres.in/api/{myPath")
	
	.then()
	.statusCode(200)
	
	
	;
	}
}
