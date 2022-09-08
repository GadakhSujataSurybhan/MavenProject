package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {
	//step1: variable declaration
		 @FindBy(xpath="//span[@class= 'user-id']") private WebElement userID;
		 @FindBy(xpath="//a[@href='/logout']")private WebElement logoutbutton;
		 
		 
		 //create constructor
		 public KiteHomePage(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
		 }
		 //3
		 
		 public  String ActualuserID()
		 {
		
		   String actualuserID = userID.getText();
		return actualuserID;
//			 if(expecteduserID.equals(getActualUserID))
//			 {
//				 System.out.println("Username is matching TC is passed");
//			 }
//			 else {
//				 System.out.println("Username is not matching TC is failed");
	//		 }
		
			
			
		 }
		 public void ClickonLogout() throws InterruptedException
		 {
			 userID.click();
			 Thread.sleep(2000);
			 logoutbutton.click();
		 }
	
			
		}
