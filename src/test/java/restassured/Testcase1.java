package restassured;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import common.Utility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Testcase1 {

	@BeforeMethod
	public void setup() {

		RestAssured.baseURI = Utility.BaseUrl();

	}

	@Test
	public void getAgents() {

		given().header("access_token", Utility.getAccessToken()).when().get("/admin/agents").then().assertThat()
				.statusCode(200).contentType(ContentType.JSON).header("Server", equalTo("nginx"));

	}

	@AfterTest
	public void reset() {

		Utility.resetBaseUrl();

	}

}
