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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequestSaveResInFile2 {

	static Response res;
	static XSSFRow row;

	@Test(dataProvider="requestId")
	public void apiTest(Integer requestId) throws IOException 	{

		res = 
				given()
				.contentType(ContentType.JSON)

				.when()
				.get("http://localhost:3000/posts/"+requestId);

		String response = res.asString();
		System.out.println(response);	
		int rowId = 2;
		getIdSaveResponse(rowId, response);
		rowId++;
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
	@DataProvider(name="requestId")
	public static Integer[][] getRequestId() throws IOException {

		File file = new File("./SaveResponse/response2.xlsx"); FileInputStream fi =
				new FileInputStream(file);

		XSSFWorkbook wk = new XSSFWorkbook(fi);
		XSSFSheet sheet = wk.getSheet("response");
		int numRow = sheet.getPhysicalNumberOfRows();
		System.out.println(numRow);
		Integer[][] testData = new Integer[numRow][1];

		for(int i=0; i<numRow; i++)
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell requestId = row.getCell(0);			
			testData[i][0] = (int) requestId.getNumericCellValue();	
			//getIdSaveResponse(i, response);
		}
		return testData;
	}


	public static void getIdSaveResponse(int rowId, String response) throws IOException {

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