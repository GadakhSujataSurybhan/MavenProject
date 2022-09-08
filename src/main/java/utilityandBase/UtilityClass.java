package utilityandBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityClass {
	static Sheet mySheet;
 public static String ReadDetaFromexcel(int rowindex, int cellindex) throws EncryptedDocumentException, IOException
 {
	 FileInputStream MyFile = new FileInputStream("C:\\webdriver\\exsheets.xlsx");
	    mySheet = WorkbookFactory.create(MyFile).getSheet("Sheet3");
	    String value = mySheet.getRow(rowindex).getCell(cellindex).getStringCellValue();
	    return value;
 }
 public static void takeScreenshort(WebDriver driver, int TCID) throws IOException
 {
	 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 File destination= new File("C:\\Users\\sudarshan\\Documents\\screenshort\\"+TCID+"screenshort.png");
		FileHandler.copy(source, destination);
		Reporter.log("screenshot taken for TC " +TCID,true); 
 }
}
