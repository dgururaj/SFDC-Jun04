package bootcamp;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ShadowElementHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Launch Browser
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		// disable browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Login into SFDC
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		String parentWindowHandle = driver.getWindowHandle();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Learn More']")));
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		Set<String> Allwindowhandles = driver.getWindowHandles();
		
		for (String allwindowhandles : Allwindowhandles) {
			
			if(!allwindowhandles.equals(parentWindowHandle)) {
				driver.switchTo().window(allwindowhandles);
			}
			
		}
		
		System.out.println(driver.getTitle());
		
		
		Shadow shadow = new Shadow(driver);
		WebElement we = shadow.findElementByXPath("//span[text()='Products']");
		we.click();
		
		Actions act = new Actions(driver);
		act.moveToElement(we).build().perform();
		
		
		
		
		
	}

}
