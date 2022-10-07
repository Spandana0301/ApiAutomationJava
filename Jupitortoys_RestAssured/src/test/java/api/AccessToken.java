package api;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AccessToken {
	
	String accessToken;
	@Test
	public void getAccessToken() {
	 RestAssured.baseURI ="https://dev-96443153.okta.com";
     RestAssured.basePath="/";
    Response response=(Response) RestAssured.given().accept("application/json").contentType("application/x-www-form-urlencoded")
    		.params("scope","mod_custom","grant_type","client_credentials")
    		.post("oauth2/default/v1/token").then().assertThat().statusCode(200);
    accessToken=response.jsonPath().getString("access_token");
	
	}
}
