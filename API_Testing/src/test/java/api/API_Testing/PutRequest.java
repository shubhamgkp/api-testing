package api.API_Testing;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PutRequest {

	public static void main(String[] args) {
		
		Data data = new Data();
		data.setAddress("updated Gurgaon");
		//data.setEmpcode("1234");
		
		Response res = 
		
		given()
		.contentType(ContentType.JSON)
		.body(data)
		
		.when()
		.put("http://localhost:3000/posts/2");
		
		System.out.println(res.asString());
	}
}
