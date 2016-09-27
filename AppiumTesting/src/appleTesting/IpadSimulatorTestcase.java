/**
 * 
 */
package appleTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;

/**
 * @author atariq
 *
 */
public class IpadSimulatorTestcase {
	WebDriver driverObj; 
	WebElement currentElement;
	
	@BeforeTest  
	public void beforeTest() throws MalformedURLException { //set capabilities required  
	DesiredCapabilities capabilities = new DesiredCapabilities();  
	/*
	Simulator Settings
	*/
	capabilities.setCapability("deviceName", "iPad Air");  
	capabilities.setCapability("platformName", "iOS");  
	capabilities.setCapability("platformVersion", "9.3");  
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
    driverObj = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//instantiate driver  
	driverObj.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);  
	 }  
//	  
//	 @Test(description="Check if All Navigation Menu Items are displayed", priority =1)
//	 public void navigationMenuTest() throws InterruptedException
//	 {
//		 
//	  driverObj.get("https://www.dreamteamfc.com/c/");    
//	  driverObj.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);  
//	  System.out.println(driverObj.getCurrentUrl());  
//	  currentElement= driverObj.findElement(By.xpath("/html/body/div[1]/div/header/div/button"));
//	  if(currentElement.isDisplayed())
//	  {
//	  System.out.println("Menu Button Found");
//	  currentElement.click();
//	  driverObj.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);  
//	  Thread.sleep(5000);
//	  }
//	  else
//	  System.out.println("Menu Button Not Found");
//	  }
//	 
	 @Test (description="Test All Menu Items Are Present ",  priority =2)
	 public void menuItems() throws InterruptedException
	 {
		 driverObj.get("https://www.dreamteamfc.com/c/");    
		 driverObj.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);  
		 System.out.println(driverObj.getCurrentUrl());  
		 currentElement=driverObj.findElement(By.linkText("NEWS & GOSSIP"));
		if(currentElement.isDisplayed())
		{
		  System.out.println("NEWS & GOSSIP Button Found");
		  currentElement.click();
		 Thread.sleep(5000);

		}
		else
		System.out.println("NEWS & GOSSIP Button Not Found");
	 	}
	 
	 @AfterTest  
	 public void afterTest() {  
	  driverObj.quit();  
	 }  

}
