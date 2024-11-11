package sel.basictests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FirstTest {

    private static WebDriver driver;

    public static void main(String args[]) {
    	
//    	WebDriverManager.chromedriver().setup();
    	WebDriverManager.chromedriver().driverVersion("130.0.6723.58").setup();
    	
    	
        // Initialize the WebDriver
        driver = new ChromeDriver();
        
//        driver = new FirefoxDriver(); we can also run the same code on the firefox also
        
        driver.get("https://www.google.com/"); 
        driver.manage().window().maximize(); // to open the browser in maximum window
        
//        driver.findElement(By.name("q")).sendKeys("Who is Ravi Verma");
        
        // or we can do below
       
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Who is Ravi Verma",Keys.ENTER);
        	
        
        String title = driver.getTitle();
        System.out.println(title);
        
        String url = driver.getCurrentUrl();
        System.out.println(url);
        
        String expectedTitle = "Who is Ravi Verma - Google Search";
        String expectedUrl = "https://www.google.com/search?q=Who+is+Ravi+Verma&sca_esv=fbd782787e425adc&source=hp&ei=-iMvZ773MZ2hnesP9N7O8Q8&iflsig=AL9hbdgAAAAAZy8yCsRD1o0i7cYIuxeX85Nq16d7tUeI&ved=0ahUKEwi-3If28M6JAxWdUGcHHXSvM_4Q4dUDCA8&uact=5&oq=Who+is+Ravi+Verma&gs_lp=Egdnd3Mtd2l6IhFXaG8gaXMgUmF2aSBWZXJtYUhBUABYPnAAeACQAQCYAQCgAQCqAQC4AQPIAQD4AQGYAgCgAgCYAwCSBwCgBwA&sclient=gws-wiz";
        
        
        driver.close(); // closes the browser
        
    }
}
