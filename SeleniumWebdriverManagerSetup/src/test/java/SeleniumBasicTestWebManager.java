import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicTestWebManager {

	static String browser;
	static WebDriver driver;

	public static void main(final String[] args) {

		setBrowser();
		setBrowserConfig();
		runTest();

	}
	// Split the actions into three functions as given below so repetition of code
	// is not required
	// SetBrowser
	// setBrowserConfig
	// runTest

	public static void setBrowser() {
		browser = "Chrome";
		//browser = "Firefox";
	}

	public static void setBrowserConfig() {

		// To specifically use/invoke a particular version of ChromeDriver
		// WebDriverManager.chromedriver().version("79.0.3945.36").setup();

		if (browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			// driver = new ChromeDriver();
		}

		if (browser.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
			// driver = new FirefoxDriver();
		}
	}

	public static void runTest() {

		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*
		 * FROM FIELD: ================ Alternate method by xpath by assigning to a
		 * variable: final
		 */// WebElement From =
			// driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/input"*
			// ));

		// WORKING CODE:First bring the focus of cursor to the text field and enter the
		// text so drop down displays
		driver.findElement(By.id("src")).sendKeys("Koyambedu, Chennai");
		/*
		 * Click on drop down selection usimg rel xpath. This moved cursor focus to next
		 * text box which is To field.
		 */
//		driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/ul/li[1]")).click();
		driver.findElement(By.xpath("//li[@class='selected']")).click();
		/*
		 * Tried initially by sending text and then enter which failed to pick values
		 * with a red highlight
		 */
		/// From.sendKeys("Koyambedu, Chennai");
		// From.sendKeys(Keys.ENTER);

		/*
		 * TO FIELD: =================== //final WebElement To =
		 * driver.findElement(By.xpath(
		 * "/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/input"
		 * ));
		 */
		// WORKING CODE:
		// First bring the focus of cursor to the text field and enter the text so drop
		// down displays
		driver.findElement(By.id("dest")).sendKeys("Goa (All Locations)");
		//driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/ul/li[1]")).click();
		driver.findElement(By.xpath("//li[@class='selected']")).click();
		
		// Tried initially by sending text and then enter which failed to pick values
		// with a red highlight
		// To.sendKeys(Keys.ENTER);
		// To.sendKeys(Keys.TAB);

		/*
		 * ONWARDDATE FIELD: ====================== WORKING CODE:
		 */
		// final WebElement OnwardDate =
		// driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[3]/div/input"));
		// First bring the focus of cursor to the text field and enter the text so drop
		// down displays
			WebElement OnwardDate = driver.findElement(By.id("onward_cal"));
		// driver.findElement(By.xpath("//label[@class='db text-trans-uc']")).click();
		driver.findElement(
				By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='current day'][contains(text(),'24')]"))
				.click();
		// Had to tab because cursor focus didnt jump to next field automatically.
		OnwardDate.sendKeys(Keys.TAB);

		/*
		 * Alternate method by xpath
		 * driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[6]/td[5]")).
		 * click(); WebElement OnwardDate = driver.findElement(By.
		 * xpath("<div class=\"rb-calendar hide\" id=\"rb-calendar_onward_cal\" style=\"position: absolute; top: 263px; width: 212px; left: 665px;\"><table class=\"rb-monthTable first last\"><tbody><tr class=\"rb-monthHeader\"><td class=\"prev\"><button class=\"hide\">&lt;</button></td><td class=\"monthTitle\" colspan=\"5\">Feb 2020</td><td class=\"next\"><button>&gt;</button></td></tr><tr><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th><th>Su</th></tr><tr><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"past day\">1</td><td class=\"past day\">2</td></tr><tr><td class=\"past day\">3</td><td class=\"past day\">4</td><td class=\"past day\">5</td><td class=\"past day\">6</td><td class=\"past day\">7</td><td class=\"past day\">8</td><td class=\"past day\">9</td></tr><tr><td class=\"past day\">10</td><td class=\"past day\">11</td><td class=\"past day\">12</td><td class=\"past day\">13</td><td class=\"past day\">14</td><td class=\"past day\">15</td><td class=\"past day\">16</td></tr><tr><td class=\"past day\">17</td><td class=\"past day\">18</td><td class=\"past day\">19</td><td class=\"past day\">20</td><td class=\"current day\">21</td><td class=\"we day\">22</td><td class=\"we day\">23</td></tr><tr><td class=\"wd day\">24</td><td class=\"wd day\">25</td><td class=\"wd day\">26</td><td class=\"wd day\">27</td><td class=\"wd day\">28</td><td class=\"we day\">29</td><td class=\"empty day\"> </td></tr><tr><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"empty day\"> </td><td class=\"empty day\"> </td></tr></tbody></table></div>"
		 * )); OnwardDate.sendKeys("19-Feb-2020");
		 */

		/*
		 * RETRUN DATE FEILD: ===================== Alternate method by xpath final
		 * WebElement ReturnDate = driver.findElement(By.xpath(
		 * "/html/body/section/div[2]/main/section/div/div[2]/section/div/div[4]/div/label"
		 * ));
		 */
		// WORKING CODE:
		WebElement ReturnDate = driver.findElement(By.id("return_cal"));
		// This test case worked only by inspect element path on drop down using rel
		// xpath
		driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']//td[@class='wd day'][contains(text(),'26')]")).click();

		// struggled initially by sending data and enter, so tried all these.
		// ReturnDate.sendKeys("19-Feb-2020");
		// ReturnDate.sendKeys(Keys.RETURN);

		/*
		 * BUTTON CLICK: ================== This test case took long time because of the
		 * text drop down select feature wasnt selected so fields were not selected
		 * actually and hence submit button wasn't clickable
		 */
		// WORKING CODE:
		driver.findElement(By.id("search_btn")).click();

		// Alternate method by xpath
		// driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/button")).click();

		String BusFound = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]/span")).getText();
		System.out.println(BusFound +" Found");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
	}
}