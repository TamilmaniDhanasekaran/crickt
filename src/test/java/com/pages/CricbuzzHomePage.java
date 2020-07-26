package com.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tamilmani Dhanasekaran
 *
 *
 *     To click and verify the home page given scenario
 */

public class CricbuzzHomePage {

	public static WebDriver driver;
	static JavascriptExecutor js = null;

	public CricbuzzHomePage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@title='Cricket Schedule'])[1]")
	public static WebElement schedule;

	@FindBy(id = "seriesDropDown")
	public WebElement series;

	@FindBy(xpath = "//span[contains(text(),'Australia')]")
	List<WebElement> australiaMatches;

	@FindBy(className = "cb-col-16 cb-col text-bold cb-mnth")
	List<WebElement> matchDates;

	@FindBy(xpath = "(//a[@class='cb-hm-mnu-itm'])[1]")
	public WebElement livescore;

	@FindBy(id = "recent-tab")
	public static WebElement recent;

	@FindBy(xpath = "(//a[@class='cb-text-link cb-mtch-lnks'])[2]")
	public WebElement scorecard;

	/**
	 * Launch browser is used to set the path for chrome driver and launch the url
	 *
	 * @throws InterruptedException the interrupted exception
	 */

	public void launchBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/dtm/Desktop/Android_device_photos/chromedriver");

		driver = new ChromeDriver();

		driver.get("https://www.cricbuzz.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
	}

	/**
	 * Click schedule is used to click the schedule button in the home page
	 *
	 * @throws InterruptedException the interrupted exception
	 */

	public void clickSchedule() throws InterruptedException {

		Thread.sleep(1000);
		schedule.click();
		Thread.sleep(1000);

	}

	/**
	 * Gets the all match is used to scroll down the page by using javaScript
	 * executor
	 *
	 * 
	 * @throws InterruptedException the interrupted exception
	 */

	public void getAllMatch() throws InterruptedException {

		for (int i = 0; i <= 18; i++)

		{
			js = (JavascriptExecutor) driver;
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,10000)");
			Thread.sleep(2000);
		}

	}

	public void clickSeries() throws InterruptedException {

		series.click();
		for (int i = 0; i <= 2; i++)

		{
			js = (JavascriptExecutor) driver;
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,10000)");
			Thread.sleep(1000);
		}

	}

	/**
	 * Click livescore is used to click the livescore button in the home page
	 *
	 * @throws InterruptedException the interrupted exception
	 */

	public void clickLivescore() throws InterruptedException {
		livescore.click();
		Thread.sleep(1000);

	}

}

