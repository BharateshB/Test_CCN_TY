package com.tyss.api.scripts;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class TYSS_ReqRes_Delete_Test {
		@Test
		public void deleteUser() {
			given()
			.when()
			.delete("https://reqres.in/api/users/2")
			.then()
			.statusCode(204)
			.log().all();
	}
}
