package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement contactName;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement contactEmail;
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement contactPhone;
    @FindBy(xpath = "//input[@id='subject']")
    private WebElement contactSubject;
    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement contactMessage;
    @FindBy(xpath = "//button[@id='submitContact']")
    private WebElement contactSubmit;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement alertMessage;
    @FindBy(xpath = "//p[normalize-space()='Shady Meadows B&B']")
    private WebElement contactHotelName;
    @FindBy(xpath = "//body/div[@id='root']/div/div[@class='container-fluid']/div[@class='row contact']/div[@class='col-sm-5']/p[2]")
    private WebElement contactHotelAddress;
    @FindBy(xpath = "//p[normalize-space()='012345678901']")
    private WebElement contactHotelPhone;
    @FindBy(xpath = "//p[normalize-space()='fake@fakeemail.com']")
    private WebElement contactHotelEmail;
    @FindBy(xpath = "//div[@class='col-sm-5']//div//p[1]")
    private WebElement submitMessageAlert;
    @FindBy(xpath = " //div[@class='pigeon-overlays']")
    private WebElement map;

    public void fillInContactForm(String name, String email, String phone, String subject, String message) {

        contactName.sendKeys(name);
        contactEmail.sendKeys(email);
        contactPhone.sendKeys(phone);
        contactSubject.sendKeys(subject);
        contactMessage.sendKeys(message);
    }

    public void clickContactSubmit() {

        contactSubmit.click();
    }

    public String checkAlertMessage() {

        return alertMessage.getText();
    }

    public String SubmitMessageAlert(){

        return submitMessageAlert.getText();
    }

    public  void invalidEmail(String email) {

        contactEmail.sendKeys(email);
    }

      public boolean checkCompanyContactDetails() {
        if (contactHotelName.isDisplayed() &&
                contactHotelAddress.isDisplayed() &&
                contactPhone.isDisplayed() &&
                contactEmail.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}


