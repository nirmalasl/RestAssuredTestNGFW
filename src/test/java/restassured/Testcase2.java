package restassured;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import static io.restassured.RestAssured.given;
import common.Utility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Testcase2 {

	@BeforeMethod
	public void setup() {

		RestAssured.baseURI = Utility.BaseUrl();

	}

	@Test
	public void createUser() {

		given().urlEncodingEnabled(true).multiPart("username", "user2407@gmail.com").multiPart("password", "User@1234")
				.multiPart("firstName", "user").multiPart("lastName", "123")
				.header("access_token", Utility.getAccessToken()).when().post("admin/users").then().assertThat()
				.statusCode(200).contentType(ContentType.JSON).header("Server", equalTo("nginx"));

	}

	@AfterTest
	public void reset() {

		Utility.resetBaseUrl();

	}

}
