package parsing_xml_data;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class PasrsingXML_data {
@Test
public void Xml_data() {
	given()
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler?page=6")
	
	
	.then()
	.statusCode(200)
	.header("Content-Type", "application/xml; charset=utf-8")
	.body("TravelerinformationResponse.page",equalTo ("6"))
	.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("asdasd"))
	.log().all()
	;
}

//approch 2 by capturing response
@Test
public void xml_response() {
Response res=	given()
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler?page=6");

Assert.assertEquals(res.getStatusCode(),200);
Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
String name=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name").toString();
	Assert.assertEquals(name, "Tigran Muradyan");
}

// if data in body is not in static order
@Test
public void xml_path() {
	boolean actual=false;
Response res=	given()
	.when()
	.get("http://restapi.adequateshop.com/api/Traveler?page=6");
    XmlPath xm =new XmlPath(res.asString());
   List<String> name= xm.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
   for(String names:name) {
	   System.out.println(names);
	   if (names.equals("Developer"))
	   {
		   actual= true;
	   }
   }
   Assert.assertEquals(actual,true);
	
}
}
