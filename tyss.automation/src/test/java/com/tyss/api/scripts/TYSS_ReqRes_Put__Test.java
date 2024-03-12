package com.tyss.api.scripts;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class TYSS_ReqRes_Put__Test {
	@Test
	public void updateUser() {
		JSONObject data=new JSONObject();
//		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name","Dell");
		data.put("job","laptop");
		given()
		.contentType("application/json")
//		.body(data)
		.body(data.toString())
		.when()
		.put("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
