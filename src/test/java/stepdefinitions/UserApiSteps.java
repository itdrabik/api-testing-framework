package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import pages.UserApiPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserApiSteps {
    private final UserApiPage userApi = new UserApiPage();
    private Response response;

    @Given("the API is available")
    public void the_api_is_available() {
        // API availability check (placeholder)
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = userApi.getUsers(2);
    }

    @When("I send a POST request to {string} with:")
    public void i_send_a_post_request_to_with(String endpoint, io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps().get(0);
        response = userApi.createUser(data.get("name"), data.get("job"));
    }

    @When("I send a PUT request to {string} with:")
    public void i_send_a_put_request_to_with(String endpoint, io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps().get(0);
        response = userApi.updateUser(2, data.get("name"), data.get("job"));
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer statusCode) {
        assertEquals(statusCode, response.getStatusCode(), "Status code is incorrect");
    }

    @Then("the response should contain a list of users")
    public void the_response_should_contain_a_list_of_users() {
        assertNotNull(response.jsonPath().getList("data"));
    }

    @Then("the response should contain the new user data")
    public void the_response_should_contain_the_new_user_data() {
        assertNotNull(response.jsonPath().getString("id"));
        assertNotNull(response.jsonPath().getString("createdAt"));
    }

    @Then("the response should contain updated user data")
    public void the_response_should_contain_updated_user_data() {
        assertNotNull(response.jsonPath().getString("updatedAt"));
    }
}
