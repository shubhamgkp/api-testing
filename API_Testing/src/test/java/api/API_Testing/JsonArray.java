package api.API_Testing;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonArray {
	
	public static void main(String[] args) {
		
		JSONObject primaryAddress = new JSONObject();
		primaryAddress.put("Ho. No.", "75");
		primaryAddress.put("Street", "Sector 55");
		primaryAddress.put("City", "Gurgaon");
		primaryAddress.put("State", "Haryana");
		
		JSONObject secondaryAddress = new JSONObject();
		secondaryAddress.put("Ho. No.", "103");
		secondaryAddress.put("Street", "Sector 44");
		secondaryAddress.put("City", "Gurgaon");
		secondaryAddress.put("State", "Haryana");
		
		JSONArray address = new JSONArray();
		address.put(0, primaryAddress);
		address.put(1, secondaryAddress);
		System.out.println(address);
	}

}
