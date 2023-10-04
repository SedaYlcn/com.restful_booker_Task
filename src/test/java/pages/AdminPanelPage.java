package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;

public class AdminPanelPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@id='doLogin']")
    private WebElement adminLogin;
    @FindBy(xpath = "//a[normalize-space()='B&B Booking Management']")
    private WebElement adminLoginPage;
    @FindBy(xpath = "//a[normalize-space()='Logout']\n")
    private WebElement adminlogout;


    public void usernameInput(String username) {

        usernameInput.sendKeys(ConfigReader.getProperty(username));
    }

    public void passwordInput(String password) {

        passwordInput.sendKeys(ConfigReader.getProperty(password));
    }

    public void clickLogin() {

        adminLogin.click();
    }

    public WebElement adminLogin() {

        return adminLogin;
    }

    public WebElement adminlogout() {

        return adminlogout;
    }

    public String adminLoginPage() {

        return adminLoginPage.getText();
    }

    public void adminLogoutClick() {

        adminlogout.click();
    }

    public void invalidUsernameInput(String username) {

        usernameInput.sendKeys(username);
    }

    public void invalidPasswordInput(String password) {

        passwordInput.sendKeys(password);
    }

}
