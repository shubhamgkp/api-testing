package api.API_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONTokener;

public class ReadJsonArrayData {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("./JSONData/dummyArray.json");
		FileInputStream fs = new FileInputStream(file);
		
		JSONTokener jt = new JSONTokener(fs);
		JSONArray ja = new JSONArray(jt);
		System.out.println(ja);
	}
}
