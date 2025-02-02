package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pages.UserApiPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserApiTest {
    private final UserApiPage userApi = new UserApiPage();

    @Test
    public void testCreateUser() {
        Response response = userApi.createUser("John Doe", "QA Engineer");

        // Response content logging
        System.out.println("Response Body: " + response.getBody().asPrettyString());

        // Checking HTTP status
        assertEquals(201, response.getStatusCode(), "Status code is incorrect");

        // Verification of data in response
        assertEquals("John Doe", response.jsonPath().getString("name"));
        assertEquals("QA Engineer", response.jsonPath().getString("job"));

        // Verify that the API returns the ID and timestamp
        assertNotNull(response.jsonPath().getString("id"));
        assertNotNull(response.jsonPath().getString("createdAt"));
    }


    @Test
    public void testGetUsers() {
        Response response = RestAssured.get("https://regres.in/api/users?page=2");

        // Checking the status of your response
        assertEquals(200, response.getStatusCode(), "Status code is incorrect");

        // Writing out the answers
        System.out.println("Response: " + response.getBody().asPrettyString());
    }
}
