package bootcamp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccountsWebtableHandling_ScrollTOEndOfPage {

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
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		// login steps
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();

		// navigate to accounts
		WebElement AppLauncher=driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		executor.executeScript("arguments[0].click();", AppLauncher);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		driver.findElement(
				By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']"))
				.click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//a[@title='Accounts']/parent::*")).click();
		WebElement element = driver.findElement(By.xpath("//a[@title='Accounts']"));
		
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);

		WebElement webE= driver.findElement(By.xpath("//span[@title='Account Name']"));
		executor.executeScript("arguments[0].click();", webE);
		Thread.sleep(5000);
		
		
		
		
		
		
		executor.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
		
		
		
		List<String> accountNames = new ArrayList<String>();
		String count = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText().replaceAll("\\D",
				"");
		System.out.println(count);
		int recordsCount = Integer.parseInt(count);
		System.out.println(recordsCount);
		
		for (int i = 1; i <= recordsCount; i++) {
			WebElement row = driver.findElement(By.xpath("(//a[@data-refid='recordId'])["+i+"]"));
			executor.executeScript("arguments[0].scrollIntoView();", row);
			accountNames.add(row.getText());
			if (i == recordsCount) {
				count = driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText()
						.replaceAll("\\D", "");
				recordsCount = Integer.parseInt(count);
			}
		}
		System.out.println(accountNames);// Get all account names from table

		/*
		 * List<WebElement> headerList = driver .findElements(By.xpath(
		 * "(//table[@data-aura-class='uiVirtualDataTable'])[1]/thead/tr/th"));
		 * System.out.println(headerList.size());
		 * 
		 * for (int i = 3; i < headerList.size(); i++) { String getHeaderText = driver
		 * .findElement(
		 * By.xpath("(//table[@data-aura-class='uiVirtualDataTable'])[1]/thead/tr/th[" +
		 * i + "]/div")) .getText(); System.out.println(getHeaderText); }
		 * 
		 * List<WebElement> allRows = driver .findElements(By.xpath(
		 * "(//table[@data-aura-class='uiVirtualDataTable'])[1]/tbody/tr"));
		 * System.out.println("Row Size::" + allRows.size());
		 * 
		 * ArrayList<String> AllAccountsList = new ArrayList<String>();
		 * 
		 * for (int i = 1; i <= allRows.size(); i++) {
		 * 
		 * List<WebElement> allcols = driver.findElements(
		 * By.xpath("(//table[@data-aura-class='uiVirtualDataTable'])[1]/tbody/tr[" + i
		 * + "]/td")); System.out.println("col Size::" + allcols.size()); //
		 * executor.executeScript("arguments[0].scrollIntoView();", savebutton); //
		 * executor.executeScript("arguments[0].click();", savebutton);
		 * 
		 * //
		 * [@id="brandBand_1"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/
		 * div/div/table/tbody/tr[1]/th/span String AccountName = driver .findElement(
		 * By.xpath("(//table[@data-aura-class='uiVirtualDataTable'])[1]/tbody/tr[" + i
		 * + "]/th/span")) .getText(); System.out.println("AccountName::" +
		 * AccountName); AllAccountsList.add(AccountName);
		 * 
		 * for (int j = 1; j < allcols.size(); j++) {
		 * 
		 * System.out.println(
		 * "(//table[@data-aura-class='uiVirtualDataTable'])[1]/tbody/tr[" + i + "]/td["
		 * + j + "]/span");
		 * 
		 * String values = driver.findElement(By.xpath(
		 * "(//table[@data-aura-class='uiVirtualDataTable'])[1]/tbody/tr[" + i + "]/td["
		 * + j + "]/span")) .getText(); System.out.println(values); }
		 * 
		 * }
		 * 
		 * System.out.println(AllAccountsList);
		 * 
		 * AllAccountsList.replaceAll(String::toUpperCase);
		 * System.out.println(AllAccountsList); ArrayLIstDemo alDemo = new
		 * ArrayLIstDemo();
		 * 
		 * System.out.println(alDemo.checkSorting(AllAccountsList));
		 * 
		 * 
		 * List<String> ordered = new ArrayList<String>(AllAccountsList);
		 * Collections.sort(ordered);
		 * 
		 * boolean inOrder = ordered.equals(AllAccountsList);
		 * System.out.println(inOrder);
		 */		
	}

}
