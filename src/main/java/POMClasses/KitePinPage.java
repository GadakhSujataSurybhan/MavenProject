package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitePinPage {
	//step1: variable declaration
@FindBy(id="pin")private WebElement pin;
@FindBy(xpath="//button[@type='submit']")private WebElement contiunebutton;

//Step 2: create constructor 

public KitePinPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//
public void enterpin(String Pin)
{
	pin.sendKeys(Pin);
}
public void clickoncontinue()
{
	contiunebutton.click();
}

}
