package com.tyss.api.scripts;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import com.tyss.reqres.pojoclass.ReqResPojoClass;

public class TYSS_ReqRes_PostPojo_Test {

	@Test
	public void createUserUsingPojo() {
		ReqResPojoClass data=new ReqResPojoClass(); 
		data.setName("HP");
		data.setJob("laptop");
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.log().all()
		.statusCode(201);
//		.body("name",equalTo("HP"))
//		.body(containsString("laptop"));
		
	}
}
