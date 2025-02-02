package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class UserApiPage {
    private static final String BASE_URL = "https://reqres.in/api";

    public Response getUser(int page) {
        return RestAssured.given()
                .get(BASE_URL + "/user?page" + page);
    }

    public Response createUser(String name, String job) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("job", job);

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .log().uri()    // URI logging
                .log().body()   // Logging the request body
                .post(BASE_URL + "/users")
                .then()
                .log().status() // Response status logging
                .log().body()   // Response logging
                .extract().response();
    }


}
