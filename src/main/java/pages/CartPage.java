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


public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	 @FindBy(xpath="//button[text()='Add to cart']")
	 WebElement addtoCartBtn;
   

    @FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div/div/input")
	WebElement quantityInput;

	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/div[2]")
	WebElement quantityUpdatePopup;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div/button[2]")
	WebElement increaseBtn;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div/button[1]")
	WebElement decreaseBtn;
	
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[1]")
	WebElement confirmRemoveBtn;
    
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[3]/div/form/button")
	WebElement placeOrderBtn;
    
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/h3/span[2]")
	WebElement addressHeading;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[3]/div[2]/div[2]")
	WebElement removeBtn;
	
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/button")
	WebElement acceptAndContinueBtn;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div/div[1]/div[4]/h3/span[2]")
	WebElement paymentPageHeading;

    public void modifyQuantity() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	increaseBtn.click();
    	Assert.assertTrue(quantityUpdatePopup.isDisplayed());
//    	Thread.sleep(4000);
    	
    }

    public void removeItem(){
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	removeBtn.click();
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div[3]/div/div[1]")));
    	confirmRemoveBtn.click();

    }

    public void proceedToBuy() {
    	placeOrderBtn.click();
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[2]/div/h3/span[2]")));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[4]/h3/span[2]")));
    	Assert.assertTrue(addressHeading.isDisplayed());
    	Assert.assertTrue(paymentPageHeading.isDisplayed());
    	driver.navigate().back();
    }

   

	public void addToCartProduct() throws InterruptedException  {
		// TODO Auto-generated method stub
		addtoCartBtn.click();
//		Thread.sleep(3000);
	}
}
