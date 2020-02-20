import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicTestWebManager {

	static String browser;
	static WebDriver driver;

	public static void main(String[] args) {

		setBrowser();
		setBrowserConfig();
		runTest();
	}

	//	SetBrowser
	//	setBrowserConfig
	//	runTest

	public static void setBrowser() {
		browser = "Chrome";
		//		browser = "Firefox";
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		driver = new ChromeDriver(options);

	}
	public static void setBrowserConfig() {

		//		To specifically use/invoke a particular version of ChromeDriver
		//		WebDriverManager.chromedriver().version("79.0.3945.36").setup();

		if (browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		//		if (browser.contains("Firefox")) {
		//			WebDriverManager.firefoxdriver().setup();
		//			driver = new FirefoxDriver();
		//		}
	}

	public static void runTest() {
		driver.get("https://www.redbus.in/");
		//driver.close();

	}
}