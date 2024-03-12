package com.tyss.api.scripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TYSS_ReqRes_PostJSON_Test {

	@Test
	public void getDataFromJSON() throws FileNotFoundException {
		File file =new File(".\\data.json");
		FileReader fr=new FileReader(file);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("")
		.then()
		.statusCode(201)
//		.body("name".equalTo("HP"))
//		.body("job".equalTo("laptop"))
		.log().all();
		
		
		
	}
}
