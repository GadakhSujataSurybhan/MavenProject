package testClasses;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilityandBase.*;
import POMClasses.KiteHomePage;
import POMClasses.KiteLoginPage;
import POMClasses.KitePinPage;
import utilityandBase.*;

public class validdateKiteAppuserID extends BaseDetails{
	KiteLoginPage login;
	KitePinPage pin;
	KiteHomePage Home;
	
	
	@BeforeClass
	public void launchthebrowser()
	{
		launchBrowser();
		 login = new KiteLoginPage(driver);
		 pin= new KitePinPage(driver);
		 Home = new KiteHomePage(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	}
	@BeforeMethod
	public void loginintokiteApp() throws EncryptedDocumentException, IOException
	{
		login.enteruserID(UtilityClass.ReadDetaFromexcel(0, 0));
		login.enterpassword(UtilityClass.ReadDetaFromexcel(0, 1));
		login.clickonloginbutton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		pin.enterpin(UtilityClass.ReadDetaFromexcel(0, 2));
		pin.clickoncontinue();
	
	}
  @Test
  public void validatekiteAPPuserID() throws EncryptedDocumentException, IOException{
	  int TCID=100;
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	  String ExpectedUserID = UtilityClass.ReadDetaFromexcel(0, 0);
	  String actualUserID = Home.ActualuserID();
	  Assert.assertEquals(actualUserID, ExpectedUserID, "ActualuserID and ExpectedUSerID not matching");
	 Reporter.log("Validated UserName", true);
	 UtilityClass.takeScreenshort(driver, TCID);
	 Reporter.log("Validated UserName", true); 
	 
  }
 @AfterMethod
  public void logoutintokiteApp() throws InterruptedException, IOException
  {
	 Home.ClickonLogout();
	 Reporter.log("Logging out", true);
	 
  }
@AfterClass
public void closetheBrowser()
{
	closeBrowser();
}
}
