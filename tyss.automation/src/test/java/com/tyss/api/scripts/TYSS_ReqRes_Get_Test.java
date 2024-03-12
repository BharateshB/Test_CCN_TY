package com.tyss.api.scripts;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class TYSS_ReqRes_Get_Test {
	@Test(enabled=false)
	public void getAllUsers() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
}
	
	@Test()
	public void getUser() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification httpreq=RestAssured.given();
		Response response=httpreq.get("api/users?page=2");
		int respcode=response.getStatusCode();
		Assert.assertEquals(respcode, 200,"success");		
	}

}
