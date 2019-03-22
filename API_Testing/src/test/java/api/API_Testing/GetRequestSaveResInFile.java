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

public class GetRequestSaveResInFile {

	static Response res;

	public static void main(String[] args) throws IOException {

		res = 
				given()
				.contentType(ContentType.JSON)

				.when()
				.get("http://localhost:3000/posts/2");

		System.out.println(res.getStatusCode());		
		System.out.println(res.asString());

		fileConnXL(res.jsonPath().get("id").toString(),res.asString());
	}

	public static void fileConn(String body) throws IOException {

		File file = new File("./SaveResponse/response.txt");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(body);		
		bw.newLine();
		bw.close();
	}

	@SuppressWarnings("unused")
	public static void fileConnXL(String id, String response) throws IOException {

		File file = new File("./SaveResponse/response.xlsx");
		FileOutputStream fs = new FileOutputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("response");

		for(int i=1;i<2;i++) {

			XSSFRow row = sheet.createRow(i); 
			for(int j=1;j<2;j++) {
				row.createCell(0).setCellValue(id);	
				XSSFCell cell = row.createCell(j); 
				cell.setCellValue(response); 
			} 
		}

		wb.write(fs);
		fs.flush();
		fs.close();		
	}
}
