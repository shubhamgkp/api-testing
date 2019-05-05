package api.API_Testing;

import org.json.JSONObject;

public class JsonObject {

	public static void main(String[] args) {
		
		JSONObject address = new JSONObject();
		address.put("Flat No.", 203);
		address.put("Street", "Sector 55");
		address.put("City", "Gurgaon");
		address.put("Pin Code", 122011);
		
		JSONObject jo = new JSONObject();
		jo.put("First Name", "Shubham");
		jo.put("Last Name", "Verma");
		jo.put("Age", 28);
		jo.put("Designation", "Sr. Engineer");
		jo.put("Address", address);
		
		System.out.println(jo);
		
	}
}
