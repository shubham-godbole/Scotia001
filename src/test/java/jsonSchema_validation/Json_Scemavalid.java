package jsonSchema_validation;

import org.testng.annotations.Test;

import com.github.fge.jsonschema.main.JsonSchema;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Json_Scemavalid {
	@Test
public void validatioin() {
	given()
	.when()
	.get("https://reqres.in/api/users?page=2")
	.then()
	//.assertThat().body(JsonSchemaValidation.matchesJsonSchemaInClasspath("json_Schema.json"))
	.log().all()
	//.assertThat().body
	
	
	;
	
}
}
