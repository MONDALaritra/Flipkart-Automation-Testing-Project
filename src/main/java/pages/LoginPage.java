package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[2]/div[2]/div/div/div/div/a")
	WebElement loginBtn;
	
    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")
	public
    WebElement phoneNumberInput;

  
    @FindBy(xpath="//button[text()='Request OTP']")
	public
    WebElement requestOTPBtn;

    @FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/span[3]/span")
    WebElement loginErrorMessage;
    
    @FindBy(xpath="/html/body/div[4]/div/span")
	WebElement loginPopup;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterPhoneNumber(String phone) throws InterruptedException {
    	driver.navigate().refresh();
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
        
    }

    
    public void loginUiVerification() {
    	loginBtn.click();
    	Assert.assertTrue(phoneNumberInput.isDisplayed());
    	Assert.assertTrue(requestOTPBtn.isDisplayed());
    }

    public void clickLogin() {
    	requestOTPBtn.click();
    }

    public boolean isLoginErrorDisplayed() {
        try {
            return loginErrorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void closeLoginPopup() {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/span")));
    	
    	if(loginPopup.isDisplayed()) {
    		loginPopup.click();
    	}
    }
}
