package api.API_Testing;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PatchRequest {

	public static void main(String[] args) {
		
		Data data = new Data();		
		//data.setName("Rohit Pandey");
		data.setEmpcode("5678"); 
		/*data.setEmpcode("9876");
		 */
		
		Response res = 
				
		given()
		.contentType(ContentType.JSON)
		.body(data)
				
		.when()
		.patch("http://localhost:3000/posts/2");		
		
		System.out.println(res.asString());
		
	}
}
