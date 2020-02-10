package common;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class Utility {

	public static String BaseUrl() {
		String baseURL = "https://dantooine-api.aswat.co";
		return baseURL;
	}

	public static String getAccessToken() {

		RestAssured.baseURI = BaseUrl();
		String token = given().header("ContentType", "JSON").multiPart("username", "ziwo@aswat-telecom.com")
				.multiPart("password", "9c6a239c-8c5d-4d95-b997-76f1ce134c55").post("/auth/login").then().extract()
				.response().path("content.access_token").toString();
		// System.out.println(token);
		return token;

	}

	public static void resetBaseUrl() {
		RestAssured.baseURI = null;
	}
}
