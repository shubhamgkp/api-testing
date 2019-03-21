package api.API_Testing;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


public class PostRequest {

	public static void main(String[] args) {

		EmpDetails empDet = new EmpDetails();
		empDet.setEmpID(1234);
		empDet.setDoj("01-March-2019");
		empDet.setDesignation("Software QA");
		empDet.setDept("QA Department");
		
		Address adr = new Address();
		adr.setHoNo(75);
		adr.setStreet("Sector 55");
		adr.setCity("Gurgaon");
		adr.setState("Haryana");
		
		BasicDetails bd = new BasicDetails();
		bd.setFirstName("Shubham");
		bd.setLastName("Verma");
		bd.setAge(30);
		bd.setEmpDet(empDet);
		bd.setAdr(adr);
		
		Response res = 
		given()
		.contentType(ContentType.JSON)
		.body(bd)
		
		.when()
		.post("http://localhost:3000/posts/");
		
		System.out.println(res.statusCode());
		System.out.println(res.asString());	
		
	}
}