package api.API_Testing;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class PostRequestArray {

	public static void main(String[] args) {
		
		EmpDetails2 emp = new EmpDetails2();
		emp.setEmpID(8765);
		emp.setDesignation("Software QA");
		emp.setDept("QA");
		emp.setDoj("08-Mar-2019");
		
		Address2[] adr = new Address2[2];
		adr[0] = new Address2();
		adr[0].setHoNo(2345);
		adr[0].setStreet("Sector 55");
		adr[0].setCity("Gurgaon");
		adr[0].setState("Haryana");
		
		adr[1] = new Address2();
		adr[1].setHoNo(8888);
		adr[1].setStreet("Indirapuram");
		adr[1].setCity("Ghaziabaad");
		adr[1].setState("UP");
		
		BasicDetails2 bd = new BasicDetails2();
		bd.setFirstName("Rajesh");
		bd.setLastName("Yadav");
		bd.setAge(30);
		bd.setEmpDet(emp);
		bd.setAdr(adr);
				
		Response res =
		
		given()
		.contentType(ContentType.JSON)
		.body(bd)
		
		.when()
		.post("http://localhost:3000/posts/");
		
		System.out.println(res.asString());	
		
		System.out.println(res.jsonPath().get("adr[1].city"));
		
	}
}
