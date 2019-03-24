package api.testing.twitterapi;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class DeleteTweet {


	public static void main(String[] args) {

		String API_Key = "I9HliRN46eUM21enxlqZxgd5v";
		String API_Secret_Key = "woVx8oPhBcfyEreONgwBWU14w2XKjhdiFpDcstwTXeleixyOFc";
		String Access_Token = "790217985587748864-0vSYY8y0KpGbQYehqBncavovlZqmeNo";
		String Access_Token_Secret = "XPmgIFQpWX9hVbh1C8R3iGuHwpVMrF8jEhxblguRwFdfs";

		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";

		Response res =
				given()
				.contentType(ContentType.JSON)
				.auth()
				.oauth(API_Key, API_Secret_Key, Access_Token, Access_Token_Secret)
				.queryParam("count", "2")

				.when()
				.post("/destroy");

		System.out.println(res.getStatusCode());
		System.out.println(res.asString());		
	}
}
