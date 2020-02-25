package webPagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedBusSearchPage {
	WebDriver driver;

	By busTicketsFrom = By.id("src");

	By busTicketsTo = By.id("dest");

	By busTicketsOnwardDate = By.id("onward_cal");

	By busTicketsReturndDate = By.id("return_cal");

	By busTicketsSearchbtn = By.id("search_btn");

	// By busesFoundResults =
	// By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]/span");
	By busesFoundResults = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]/span");

	public RedBusSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	// Set Starting place name in from textbox
	public void setFromLocation(String strFromLocation) {
		driver.findElement(busTicketsFrom).sendKeys(strFromLocation);
		// driver.findElement(busTicketsFrom).findElement(By.xpath("//li[@class='selected']")).click();
		driver.findElement(By.xpath("//li[@class='selected']")).click();
	}

	// Set destination place name in To textbox
	public void setToLocation(String strToLocation) {
		driver.findElement(busTicketsTo).sendKeys(strToLocation);
		driver.findElement(By.xpath("//li[@class='selected']")).click();
	}

	// Set Start Date in Onward Date calendar
	public void setStartDate() {
		driver.findElement(busTicketsOnwardDate);
		driver.findElement(
				By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='current day'][contains(text(),'25')]"))
				.click();
		driver.findElement(busTicketsOnwardDate).sendKeys(Keys.TAB);
	}

	// Set Return Date in Return Date calendar
	public void setReturnDate() {
		// driver.findElement(busTicketsReturndDate);
		driver.findElement(By.xpath("//div[@id='rb-calendar_return_cal']//td[@class='wd day'][contains(text(),'28')]"))
				.click();
	}

	// Click on Search button
	public void clickSearchBtn() {
		driver.findElement(busTicketsSearchbtn).click();
	}

	// Get the buses found search results after clicking on Search button
	public String busesFoundRes() {
		return driver.findElement(busesFoundResults).getText();
	}
}
