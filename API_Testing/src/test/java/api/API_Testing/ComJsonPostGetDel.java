package api.API_Testing;

import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class ComJsonPostGetDel {

	@Test
	public void postCompJsonGetDel() {

		EmpDetails ed = new EmpDetails();
		ed.setEmpID(1234);
		ed.setDept("QA");
		ed.setDesignation("Software QA");
		ed.setDoj("08-Mar-2019");

		Address ad = new Address();
		ad.setHoNo(75);
		ad.setStreet("Raiganj North");
		ad.setCity("Gorakhpur");
		ad.setState("UP");

		BasicDetails bd = new BasicDetails();
		bd.setFirstName("Rajesh");
		bd.setLastName("Yadav");
		bd.setAge(30);
		bd.setEmpDet(ed);
		bd.setAdr(ad);

		Response res =
				given()
				.contentType(ContentType.JSON)
				.body(bd)

				.when()
				.post("http://localhost:3000/posts");

		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		System.out.println(res.asString());
		
		int id = res.jsonPath().get("id");
		
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/posts/"+id);
		
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		
		int resId = res.jsonPath().get("id");
		
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.delete("http://localhost:3000/posts/"+resId);
		
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
		
	}
}
