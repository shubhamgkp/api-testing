package api.API_Testing;

import static com.jayway.restassured.RestAssured.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequest {

	static Response res;

	public static void main(String[] args) throws IOException {

		res = 
				given()
				.contentType(ContentType.JSON)

				.when()
				.get("http://localhost:3000/posts/5");


		System.out.println(res.getStatusCode()); 
		System.out.println(res.asString());
		
	}
}
