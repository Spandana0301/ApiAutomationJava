package api;

import static org.hamcrest.Matchers.is;
import org.testng.annotations.Test;
import data.PostApiDetails;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import test.BaseUri;

public class ApiRequestsForNewToy extends AccessToken {

	PostApiDetails postapidetails = new PostApiDetails();
	BaseUri baseuri = new BaseUri();
	String responsebody;
	static int id;

	@Test(priority = 2)
	public void createNewToy() {
		postapidetails.setPrice(11.78f);
		postapidetails.setCategory("Toys");
		postapidetails.setTitle("Joker");
		postapidetails.setSize("Small");
		postapidetails.setStock(4);
		Response response = RestAssured.given().contentType("application/json")
				.header("Authorization", "Bearer " + accessToken).body(postapidetails).when().post(baseuri.getUri());
		responsebody = response.body().asString();
		JsonPath jsonpath = new JsonPath(responsebody);
		id = jsonpath.getInt("id");

	}

	@Test(priority = 3)
	public void patchingToyPrice() {
		String basePath = "/" + id;
		postapidetails.setPrice(13.45f);
		RestAssured.given().contentType("application/json").header("Authorization", "Bearer " + accessToken)
				.body(postapidetails).when().patch(baseuri.getUri() + basePath).then().body("price", is(13.45f));

	}

	@Test(priority = 4)
	public void deleteCreatedToy() {
		String basePath = "/" + id;
		RestAssured.given().header("Authorization", "Bearer " + accessToken).when().delete(baseuri.getUri() + basePath)
				.then().assertThat().statusCode(200);

	}

}
