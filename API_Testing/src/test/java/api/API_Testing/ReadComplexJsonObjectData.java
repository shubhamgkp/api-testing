package api.API_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ReadComplexJsonObjectData {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("./JSONData/jsonData.json");
		FileInputStream fs = new FileInputStream(file);

		JSONTokener jt = new JSONTokener(fs);
		JSONObject jo = new JSONObject(jt);

		System.out.println("***************Getting full json********************");
		System.out.println(jo.toString());
		System.out.println("*************************************************************************");

		System.out.println();

		System.out.
		println("************Parsing the JsonArray that is Comments************");
		JSONArray comments=jo.getJSONArray("comments");
		System.out.println(comments);
		
		System.out.println();
		
		System.out.println("************Parsing the Value of key that is Body************");
		JSONObject body = comments.getJSONObject(0);
		System.out.println(body.get("body"));		

	}
}
