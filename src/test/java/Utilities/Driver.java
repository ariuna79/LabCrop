package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

//	private Driver() {
//		
//	}
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = ConfigurationReader.getProperty("browser");
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().window().maximize();
				PageInitializer.initialize();
				break;
			case "chrome-headless":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().window().maximize();
				
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().window().maximize();
				break;
			case "firefox-headless":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
				driver.get(ConfigurationReader.getProperty("url"));
				driver.manage().window().maximize();
				break;
			case "ie":
				if (!System.getProperty("os.name").toLowerCase().contains("windows"))
					throw new WebDriverException("Your OS doesn't support Internet Explorer");
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "edge":
				if (!System.getProperty("os.name").toLowerCase().contains("windows"))
					throw new WebDriverException("Your OS doesn't support Edge");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "safari":
				if (!System.getProperty("os.name").toLowerCase().contains("mac"))
					throw new WebDriverException("Your OS doesn't support Safari");
				WebDriverManager.getInstance(SafariDriver.class).setup();
				driver = new SafariDriver();
				break;
			}
		}
		return driver;
	}
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}//end class
