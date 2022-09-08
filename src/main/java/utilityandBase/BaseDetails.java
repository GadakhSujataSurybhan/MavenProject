package utilityandBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BaseDetails {
	protected WebDriver driver;
 public void launchBrowser()
 {
	 Reporter.log("Launching browser",true);
	 System.setProperty("webdriver.gecko.driver","C:\\webdriver\\geckodriver.exe");
	 driver = new FirefoxDriver();
//	  ChromeOptions opt = new ChromeOptions();
//	 opt.addArguments("--disable-notifications");
//		driver= new ChromeDriver(opt);
	  driver.get("https://kite.zerodha.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.manage().window().maximize();
		Reporter.log("Browserlaunched sussess",true);
 }
 public void closeBrowser()
 {
	 driver.close();
	 Reporter.log("Browser closed sussess",true); 
 }

}
