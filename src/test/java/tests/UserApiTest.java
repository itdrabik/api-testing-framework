package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApiTest {

    @Test
    public void testGetUsers() {
        Response response = RestAssured.get("https://regres.in/api/users?page=2");

        // Checking the status of your response
        assertEquals(200, response.getStatusCode(), "Status code is incorrect");

        // Writing out the answers
        System.out.println("Response: " + response.getBody().asPrettyString());
    }
}
