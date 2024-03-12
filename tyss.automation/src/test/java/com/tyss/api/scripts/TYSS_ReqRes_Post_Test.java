package com.tyss.api.scripts;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class TYSS_ReqRes_Post_Test {

	@Test
	public void createUser() {
		JSONObject data=new JSONObject();
//		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name","HP");
		data.put("job","laptop");
		given()
		.contentType("application/json")
//		.body(data)
		.body(data.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
		
	}
}
