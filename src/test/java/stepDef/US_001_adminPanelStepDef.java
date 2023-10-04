package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import pages.AdminPanelPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_001_adminPanelStepDef {

    AdminPanelPage adminPanel = new AdminPanelPage();

    @Given("I navigate to the admin panel page")
    public void i_navigate_to_the_admin_panel_page() {

        Driver.getDriver().get(ConfigReader.getProperty("adminURL"));
    }

    @When("I enter valid {string} and {string}")
    public void iEnterValidAnd(String username, String password) {

        ReusableMethods.jsScrollBy(500);
        adminPanel.usernameInput(username);
        adminPanel.passwordInput(password);
    }

    @When("I log into the panel")
    public void iLogIntoThePanel() {

        adminPanel.clickLogin();
    }

    @And("The {string} is displayed")
    public void theIsDisplayed(String expectedText) {

        assertEquals(expectedText, adminPanel.adminLoginPage());
    }

    @When("I can Logout from the page")
    public void iCanLogoutFromThePage() {

        adminPanel.adminLogoutClick();
    }

    @Then("Login button is displayed")
    public void loginButtonIsDisplayed() {

        assertTrue(adminPanel.adminLogin().isDisplayed());
    }

    @Then("I closed the page")
    public void i_closed_the_page() {

        Driver.closeDriver();
    }

    @Given("I enter invalid {string} and {string}")
    public void iEnterInvalidAnd(String username, String password) {

       ReusableMethods.jsScrollBy(800);

       adminPanel.invalidUsernameInput(username);
       adminPanel.invalidPasswordInput(password);
    }

    @Then("I click the login")
    public void iClickTheLogin() {

        ReusableMethods.waitForVisibility(adminPanel.adminLogin(), 3);
        adminPanel.clickLogin();
    }

    @Then("The login should be displayed")
    public void theLoginShouldBeDisplayed() {

        assertTrue(adminPanel.adminLogin().isDisplayed());
    }

}




