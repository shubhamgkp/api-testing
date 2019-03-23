package api.API_Testing;

import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class DeleteRequest {

	public static void main(String[] args) {

		Response res =
				given()
				.contentType(ContentType.JSON)		

				.when()
				.delete("http://localhost:3000/posts/10");

		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		System.out.println(res.asString());
	}
}
