package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class UserApiPage {
    private static final String BASE_URL = "https://reqres.in/api";

    public Response getUsers(int page) {
        return RestAssured.given()
                .log().uri()
                .get(BASE_URL + "/users?page=" + page)
                .then()
                .log().status()
                .log().body()
                .extract().response();
    }

    public Response createUser(String name, String job) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("job", job);

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .log().uri()
                .log().body()
                .post(BASE_URL + "/users")
                .then()
                .log().status()
                .log().body()
                .extract().response();
    }

    public Response updateUser(int userId, String name, String job) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("job", job);

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .log().uri()
                .log().body()
                .put(BASE_URL + "/users/" + userId)
                .then()
                .log().status()
                .log().body()
                .extract().response();
    }
}
