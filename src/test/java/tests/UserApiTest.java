package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pages.UserApiPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserApiTest {
    private final UserApiPage userApi = new UserApiPage();

    @Test
    public void testGetUsers() {
        Response response = userApi.getUsers(2);

        // Verify response status code
        assertEquals(200, response.getStatusCode(), "Status code is incorrect");

        // Print API response
        System.out.println("Response: " + response.getBody().asPrettyString());
    }

    @Test
    public void testCreateUser() {
        Response response = userApi.createUser("John Doe", "QA Engineer");

        // Log response body
        System.out.println("Response Body: " + response.getBody().asPrettyString());

        // Verify HTTP status code
        assertEquals(201, response.getStatusCode(), "Status code is incorrect");

        // Verify response data correctness
        assertEquals("John Doe", response.jsonPath().getString("name"));
        assertEquals("QA Engineer", response.jsonPath().getString("job"));

        // Check if API returns ID and timestamp
        assertNotNull(response.jsonPath().getString("id"));
        assertNotNull(response.jsonPath().getString("createdAt"));
    }

    @Test
    public void testUpdateUser() {
        Response response = userApi.updateUser(2, "Jane Doe", "Senior QA Engineer");

        // Verify response status code
        assertEquals(200, response.getStatusCode(), "Status code is incorrect");

        // Verify response data correctness
        assertEquals("Jane Doe", response.jsonPath().getString("name"));
        assertEquals("Senior QA Engineer", response.jsonPath().getString("job"));

        // Check if API returns `updatedAt` timestamp
        assertNotNull(response.jsonPath().getString("updatedAt"));
    }

    @Test
    public void testDeleteUser() {
        Response response = userApi.deleteUser(2);

        //Verify response status code
        assertEquals("", response.getBody().asString(), "Response body should be empty");
    }
}
