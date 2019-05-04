package api.API_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class UpdateJsonObjectData {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("./JSONData/dummyObj.json");
		FileInputStream fs = new FileInputStream(file);
		
		JSONTokener jt = new JSONTokener(fs);
		JSONObject jo = new JSONObject(jt);
		
		System.out.println(jo);
		
		JSONObject perDet=jo.getJSONObject("Personal Details");
		perDet.put("firstname","Demo");
		
		jo.put("Personal Details", perDet);
		System.out.println(jo.toString());
	}
}
