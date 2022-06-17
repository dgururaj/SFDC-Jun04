package bootcamp;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToBottom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		// disable browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		 driver.get("https://www.amazon.in/ref=nav_logo"); 
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		        //Scroll down till the bottom of the page
		        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		

	}

}
