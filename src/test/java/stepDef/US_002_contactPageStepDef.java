package stepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import pages.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.Map;

public class US_002_contactPageStepDef {

    ContactPage contactPage = new ContactPage();
    Faker faker = new Faker();


    @Given("I navigate to the given url")
    public void iNavigateToTheGivenUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("homeURL"));
        ReusableMethods.jsScrollBy(1500);
    }

    @Given("I enter valid contact request details")
    public void i_enter_valid_contact_request_details() {

        generateFieldsAndFillContactForm(true, true, true, true, true);
    }

    @When("I submit the request")
    public void i_submit_the_request() {

        contactPage.clickContactSubmit();
    }

    @Then("the {string} message is displayed")
    public void the_message_is_displayed(String expectedMessage) {

        assertTrue(contactPage.SubmitMessageAlert().contains(expectedMessage));
    }

    @Given("I enter invalid contact request details with missing {string}")
    public void iEnterInvalidContactRequestDetailsWithMissing(String field) {

        switch (field) {
            case "name":
                generateFieldsAndFillContactForm(false, true, true, true, true);
                break;
            case "email":
                generateFieldsAndFillContactForm(true, false, true, true, true);
                break;
            case "phone":
                generateFieldsAndFillContactForm(true, true, false, true, true);
                break;
            case "subject":
                generateFieldsAndFillContactForm(true, true, true, false, true);
                break;
            case "message":
                generateFieldsAndFillContactForm(true, true, true, true, false);
                break;
        }
    }

    @Then("the {string} message is displayed below")
    public void theMessageIsDisplayedBelow(String expectedMessage) {

          assertTrue(contactPage.checkAlertMessage().contains(expectedMessage));
    }

    @Given("I enter invalid {string} format")
    public void iEnterInvalidFormat(String email) {

        contactPage.invalidEmail(email);
    }

    @Then("the {string} is displayed")
    public void theIsDisplayed(String expectedMessage) {

        assertTrue(contactPage.checkAlertMessage().contains(expectedMessage));
    }

    @Then("the contact details of hotel are displayed")
    public void theContactDetailsOfHotelAreDisplayed() {

       assertTrue(contactPage.checkCompanyContactDetails());
    }

    private void generateFieldsAndFillContactForm(boolean name, boolean email, boolean phone, boolean subject,
                                                  boolean message) {

        Map<String, String> fields = new HashMap<>();
        if (name) {
            fields.put("name", faker.name().firstName());
        } else {
            fields.put("name", "");
        }
        if (email) {
            fields.put("email", faker.internet().emailAddress());
        } else {
            fields.put("email", "");
        }
        if (phone) {
            fields.put("phone", faker.phoneNumber().cellPhone());
        } else {
            fields.put("phone", "");
        }
        if (subject) {
            fields.put("subject", "Reservation for our honeymoon");
        } else {
            fields.put("subject", "");
        }
        if (message) {
            fields.put("message", "I would like to have a nice sea view from our room for celebration");
        } else {
            fields.put("message", "");
        }

        contactPage.fillInContactForm(
                fields.get("name"), fields.get("email"), fields.get("phone"), fields.get("subject"), fields.get("message"));
    }

}
