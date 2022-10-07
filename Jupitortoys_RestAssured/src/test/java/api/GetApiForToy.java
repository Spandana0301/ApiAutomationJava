package api;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetApiForToy extends AccessToken {
	AccessToken accesstoken=new AccessToken();
	@Test(priority = 1)
	public void getApiForToy() {
	RestAssured.given().header("Authorization", "Bearer " +accessToken)
				                  .when().get(baseURI)
				                  .then().assertThat().statusCode(200).body("stock[0]",equalTo(10))
				                  .body("price[0]",is(12.99f)).body("title[0]", Matchers.equalTo("Teddy Bear"));
	}

}
