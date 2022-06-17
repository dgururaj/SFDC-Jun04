package bootcamp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboardWebtableHandling {

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
		Thread.sleep(5000);
		List<String> DashNames = new ArrayList<String>();
		String countText = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy uiOutputText']")).getText();
		countText=countText.replaceAll("\\D","");
		System.out.println(countText);
		int recordsCount = Integer.parseInt(countText);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i <= recordsCount; i++) {
			WebElement row = driver.findElement(By.xpath("(//table[@role='grid'])[1]/tbody/tr["+ i +"]/th/lightning-primitive-cell-factory/span/div/lightning-formatted-url/a"));
			js.executeScript("arguments[0].scrollIntoView();", row);
			System.out.println("Position::"+i+row.getText());
			DashNames.add(row.getText());
		}
		
System.out.println(DashNames);
		

	}

}
