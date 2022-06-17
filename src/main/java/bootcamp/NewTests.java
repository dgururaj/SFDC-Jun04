package bootcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTests {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
		
		
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();
		
		
		driver.get("https://d2w00000dnnegeal-dev-ed.lightning.force.com/lightning/o/ServiceTerritory/list?filterName=Recent");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//td[@data-aura-class='forceInlineEditCell'])[3]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[@class='slds-button trigger slds-button_icon-border'])[4]")).click();
	}

}
