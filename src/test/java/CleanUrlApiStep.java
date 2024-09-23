import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CleanUrlApiStep {

    public static final String URL = "https://cleanuri.com/api/v1/shorten";

    public static Response getCleanUrl(String longurl) {

        return given()
                .header("accept", "application/json")
                .queryParam("url", longurl)
                .post(URL)
                .then().extract().response();
    }
}
