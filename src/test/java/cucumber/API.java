package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class API extends API_Resusable{

    API_Resusable Add = new API_Resusable();

    @Given("a new address")
    public void a_new_address() {
        // Write code here that turns the phrase above into concrete actions

        throw new io.cucumber.java.PendingException();
    }

    @When("user enters a valid address")
    public void user_enters_a_valid_address() {
        // Write code here that turns the phrase above into concrete actions
        Add.addAddress();
    }

    @Then("address is added successfully")
    public void address_is_added_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
