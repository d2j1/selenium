package sel.interest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClaculateInterestTest {

    
    WebDriver driver ;
    
    
	@Test
	void testInterestRateCalculator() throws InterruptedException {
		
		File file = null ;
		
		FileInputStream fileStream= null;
		
		XSSFWorkbook workBook = null;
		XSSFSheet sheet= null;
		
		try{
			
			 file = new File("testData/interest_rate_data.xlsx");
			
			 fileStream= new FileInputStream(file);
			
			 workBook = new XSSFWorkbook(fileStream);
			 sheet = workBook.getSheet("sheet1");
			
		}catch (FileNotFoundException e) {

		e.printStackTrace();
		} catch (IOException e) {

		e.printStackTrace();
		}
		


//    	WebDriverManager.chromedriver().setup();
    	WebDriverManager.chromedriver().driverVersion("130.0.6723.58").setup();
    	
    	ChromeOptions options = new ChromeOptions();
//    	options.addArguments("--headless");
    	
        // Initialize the WebDriver
        driver = new ChromeDriver(options);
        
        driver.get("https://groww.in/calculators/simple-interest-calculator"); 
        driver.manage().window().maximize(); // to open the browser in maximum window

        
        
        
int rowCount = sheet.getLastRowNum();

//System.out.print("Row count " + rowCount);

for( int i =1; i < rowCount; i++) {
	 
	 XSSFRow row = sheet.getRow(i);
	 
	 if( row == null)
		 break;
	 
	 int id =  (int) row.getCell(0).getNumericCellValue();
	 int amount = (int) row.getCell(1).getNumericCellValue();
	 double interestRate = row.getCell(2).getNumericCellValue();
	 double years = row.getCell(3).getNumericCellValue();
//	 String expectedResult = String.valueOf(row.getCell(4).getNumericCellValue());
	 
	 System.out.println(id + " "+ amount + " "+ interestRate + " " + years + " ");
	 
	 WebElement ele = driver.findElement(By.id("PRINCIPAL_AMOUNT"));
	 ele.clear();
	 ele.sendKeys(String.valueOf(amount));
	 
	 ele = driver.findElement(By.id("RATE_OF_INTEREST"));
	 ele.clear();
	 ele.sendKeys(String.valueOf(interestRate));
	 
	 ele = driver.findElement(By.id("TIME_PERIOD"));
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].value='" + years+"';", ele);
	 	 
	 Thread.sleep(5000);
	 
	 WebElement okay = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[2]/span[1]"));
	 System.out.println("actual intertest rate "+ okay.getTagName() + okay.getText());
//	 String actualResult = driver.findElement(By.xpath("//span[normalize-space()='30,000']")).getText();
//	 double actualResultInNumber = Double.parseDouble(actualResult);
	 
	 String expectedResult = String.valueOf((amount * interestRate * years)/100);
	 
	 System.out.println("actual "+ okay.getText()+ "Expected "+ expectedResult);
	 
//	 System.out.println("actual intertest rate "+ actualResult);
//	 Assert.assertEquals(expectedResult, actualResult, "breaking for id "+ id);
//	 
	 

	
}
driver.close();



	}
}
