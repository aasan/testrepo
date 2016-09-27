/**
 * 
 */
package androidTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author atariq
 *
 */
public class AndroidPhoneTestcase {
	
	AndroidDriver<WebElement> driverObj; 
	WebElement currentElement;
	  
	 @BeforeTest  
	public void beforeTest() throws MalformedURLException { 
	 //Set below capabilities to run testcase on Android Simulator Using Appium Server
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SOLVTKN7IV95FEVK");
	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); 
	driverObj = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//instantiate driver  
	driverObj.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);  
	 
	 }  
	  
	 @Test(description="Check if All Navigation Menu Items are displayed", priority =1)
	 public void navigationMenuTest() throws InterruptedException {
	 
	 driverObj.get("https://www.dreamteamfc.com/c/");    
	 driverObj.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);  
	 System.out.println(driverObj.getCurrentUrl());  
	 currentElement= driverObj.findElement(By.xpath("/html/body/div[1]/div/header/div/button"));
	 if(currentElement.isDisplayed())
	  {
		  System.out.println("Menu Button Found");
		  currentElement.click();
		  driverObj.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);  
		  Thread.sleep(5000);
	  }
	 else
	  System.out.println("Menu Button Not Found");
	  }
	 
	 @Test (description="Test All Menu Items Are Present ",  priority =2)
	 public void menuItems() throws InterruptedException{
		
	 currentElement=driverObj.findElement(By.linkText("NEWS & GOSSIP"));
	 if(currentElement.isDisplayed())
	  {
		  System.out.println("NEWS & GOSSIP Button Found");
	  }
		else
	System.out.println("NEWS & GOSSIP Button Not Found");
	
	 }
	 
	 @AfterTest  
	 public void afterTest() {  
	  driverObj.quit();  
	 }  

}


