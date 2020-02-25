package webPagesTestPOM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import webPagesPOM.RedBusSearchPage;

public class TestRedBusSearch {

	public static WebDriver driver = null;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;

	public static void main(String[] args) {
		setup();
		TestSearchPage();
	}

	@BeforeSuite
	//	public void setBrowser() {
	//		
	//	}
	public static void setup() {
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter("RedbusSearchExtReport.html");
		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);

		// if (browser.contains("Chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
	}

	@Test
	public static void TestSearchPage() {
		// Create Redbus search page object.
		RedBusSearchPage objSearch = new RedBusSearchPage(driver);

		// creating tests
		ExtentTest test = extent.createTest("This is to verify Redbus search results", "In Chrome browser");
		test.log(Status.PASS, "PASS");

		// info(details)
		test.info("This test is to maximize the web browser from its default view");
		// To maximize browser
		driver.manage().window().maximize();

		// To open redbus site
		test.info("This test is to open redbus web page");
		driver.get("https://www.redbus.in/");

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Verify Starting point text in from textbox.
		test.info("This test is to Verify Starting point text in from textbox.");
		objSearch.setFromLocation("Koyambedu, Chennai");

		// Verify destination point text in To textbox.
		test.info("This test is to Verify destination point text in To textbox.");
		objSearch.setToLocation("Mumbai (All Locations)");

		// Verify the given start date 26th Feb is selected.
		test.info("This test is to Verify the given start date 24th Feb is selected.");
		objSearch.setStartDate();

		// Verify the given return date 28th Feb is selected.
		test.info("This test is to Verify the given return date 28th Feb is selected.");
		objSearch.setReturnDate();

		// Verify the search button is clicked in the bus tickets search results page.
		test.info("This test is to Verify the search button is clicked in the bus tickets search results page.");
		objSearch.clickSearchBtn();

		// Verify the search results are displayed based on the given search criteria
		test.info("This test is to Verify the search results are displayed based on the given search criteria.");
		objSearch.busesFoundRes();
		}

	@AfterSuite
	// Test cleanup
	public void TeardownTest() {
		TestRedBusSearch.driver.close();
		extent.flush();
	}
}
