package api.API_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadJsonObjectData {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("./JSONData/dummyObj.json");
		FileInputStream fs = new FileInputStream(file);
		
		JSONTokener jt = new JSONTokener(fs);
		JSONObject jo = new JSONObject(jt);
		
		System.out.println("***************Getting full json********************");
		System.out.println(jo.toString());
		System.out.println("*************************************************************************");
		
		System.out.println();
		
		System.out.println("************Parsing the JsonObject that is Personal Details************");
		JSONObject personalDet=jo.getJSONObject("Personal Details");
		System.out.println(personalDet);
		System.out.println("*************************************************************************");
		
		System.out.println();
		
		System.out.println("************Parsing the JsonArray that is Address************");
		JSONArray address=jo.getJSONArray("adr");		
		System.out.println(address);
		System.out.println();
		System.out.println("*********Parsing only the particular JsonArray that is based on array index*********");		
		/*
		 * System.out.println(address.getJSONObject(0));
		 * System.out.println(address.getJSONObject(1));
		 */
		System.out.println(address.get(0));
		System.out.println(address.get(1));
		System.out.println("*************************************************************************");
		
		
		
	}
}
