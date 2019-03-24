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

public class GetRequestSaveResInFile2 {

	static Response res;
	static XSSFRow row;

	public static void main(String[] args) throws IOException {

		int id =0; 
		int rowId=5; 
		id = getRequestId(rowId);

		res = 
				given()
				.contentType(ContentType.JSON)

				.when()
				.get("http://localhost:3000/posts/"+id);

		String response = res.asString();
		System.out.println(response);
		getIdSaveResponse(rowId, response);
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
	public static int getRequestId(int rowId) throws IOException {

		File file = new File("./SaveResponse/response2.xlsx"); FileInputStream fi =
				new FileInputStream(file);

		XSSFWorkbook wk = new XSSFWorkbook(fi); XSSFSheet sheet =
				wk.getSheet("response");

		row = sheet.getRow(rowId); 
		int cellId=(int)row.getCell(0).getNumericCellValue(); 
		return cellId;
	}


	public static void getIdSaveResponse(int rowId,String response) throws IOException {

		File file = new File("./SaveResponse/response2.xlsx");
		FileInputStream fs = new FileInputStream(file);

		XSSFWorkbook wk = new XSSFWorkbook(fs);
		XSSFSheet sheet = wk.getSheet("response");

		XSSFRow row = sheet.getRow(rowId);		
		row.createCell(1).setCellValue(response);
		fs.close();

		FileOutputStream fo = new FileOutputStream(file);

		wk.write(fo);
		fo.close();
	}
}