package selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		// Opens a new window and switches to new window
		driver.switchTo().newWindow(WindowType.WINDOW);

		// Opens BrowserStack homepage in the newly opened window
		driver.navigate().to("https://www.browserstack.com/");
		
		driver.get("https://www.google.com/");

		// Opens a new tab in existing window
		driver.switchTo().newWindow(WindowType.TAB);

		// Opens Browserstack homepage in the newly opened tab
		driver.navigate().to("https://www.browserstack.com/");
		
		
		
		
		
		

	}

}
