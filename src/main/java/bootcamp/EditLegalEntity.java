package bootcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLegalEntity {

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

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Legal Entities");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//mark[text()='Legal Entities']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).click();		
		// Salesforce Automation by Anitha Manian
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Samuel Automation");
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

	}

}
