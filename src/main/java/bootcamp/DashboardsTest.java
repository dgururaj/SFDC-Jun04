package bootcamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboardsTest {

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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//mark[text()='Dashboards']"))
				.click();
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement New_Dash = driver.findElement(By.xpath("//div[text()='New Dashboard']"));
		wait.until(ExpectedConditions.elementToBeClickable(New_Dash));
		New_Dash.click();
		Thread.sleep(30000);
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(frame);
		
		WebElement Name = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
		wait.until(ExpectedConditions.visibilityOf(Name));
		Name.sendKeys("asdfghj");
		Thread.sleep(10000);
		
		WebElement createbutton = driver.findElement(By.xpath("//button[text()='Create']"));
		wait.until(ExpectedConditions.visibilityOf(createbutton));
		createbutton.click();
		Thread.sleep(10000);
		
		WebElement savebutton = driver.findElement(By.xpath("//button[text()='Done']"));
		//div[@class='slds-button-group']
		//button[text()='Done']
		//button[text()='Save']
		//savebutton.click();
		System.out.println(savebutton.isDisplayed());
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", savebutton);
		executor.executeScript("arguments[0].click();", savebutton);
		
		
		
		
		
		

	}

}
