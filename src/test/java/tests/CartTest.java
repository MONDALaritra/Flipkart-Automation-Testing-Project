package tests;




import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.DriverSetup;
import pages.CartPage;
import reports.ExtentManager;


public class CartTest extends DriverSetup{
		ExtentReports extent;
	    ExtentTest test;
		
		@BeforeClass
	    public void setupReport() {
	        extent = ExtentManager.getInstance();
	    }
	 	
	 	@Test
		public void addToCart() throws InterruptedException {
	 		test = extent.createTest("Automate test: Add product to cart");
	 		CartPage cartPage = new CartPage(driver);
	 		cartPage.addToCartProduct();
			
			
		}
	 	
		@Test(priority=1)
	    public void modifyQuantityAndVerify() throws InterruptedException{
			test = extent.createTest("Automate test: Modify quantity in cart and verify updates");
	       CartPage cartPage = new CartPage(driver);
	       cartPage.modifyQuantity();
	        
	        
	    }

		@Test(priority=3)
	    public void removeItemAndConfirm(){
			test = extent.createTest("Automate test: Remove item from cart and confirm removal");
	        CartPage cartPage = new CartPage(driver);
	        cartPage.removeItem();
	        
	    }
	 	
	 	
	    @Test(priority=2)
	    public void proceedToBuyAndCheckAddressPaymentPage() {
	    	test = extent.createTest("Automate test: Proceed to buy and check address/payment page");
	        CartPage cartPage = new CartPage(driver);
	        cartPage.proceedToBuy();
	        
	    }

	   
	    @AfterClass
	    public void tearDownReport() {
	        extent.flush();
	    }
	    
	    
}
