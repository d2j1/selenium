package sel.headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowsers {
	
	public static void main(String args[]) {
		
WebDriverManager.chromedriver().driverVersion("130.0.6723.58").setup();
    	
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");
    	
        // Initialize the WebDriver
		WebDriver driver = new ChromeDriver(options);
        
		
	}

}
