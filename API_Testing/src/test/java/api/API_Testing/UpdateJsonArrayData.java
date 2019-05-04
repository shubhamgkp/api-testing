package api.API_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class UpdateJsonArrayData {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("./JSONData/dummyObj.json");
		FileInputStream fs = new FileInputStream(file);
		
		JSONTokener jt = new JSONTokener(fs);
		JSONObject jo = new JSONObject(jt);
		
		System.out.println(jo);
		
		JSONArray adr = jo.getJSONArray("adr");
		JSONObject street = adr.getJSONObject(1);
		street.put("street", "Sector 44");
		
		System.out.println(jo.put("adr", adr));
	}
}
