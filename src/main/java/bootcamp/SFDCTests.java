package bootcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCTests {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(
				By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']"))
				.click();
		Thread.sleep(5000);

		//driver.findElement(By.xpath("//a[@title='Accounts']/parent::*")).click();

		WebElement element = driver.findElement(By.xpath("//a[@title='Accounts']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);

		
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Ipsum LYX");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']")).getText());
		
		
		// 

	}

}
