package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AustraliaSchedulePage extends CricbuzzHomePage {

	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileOutputStream fos;
	public static XSSFRow row1;
	public static String filePath = "/Users/dtm/Desktop/cricbuzzUI/src/test/java/com/TestData/DTM_Cricbuzz.xlsx";
	public static String countryToVerify = "Australia";

	@FindBy(xpath = "//div[contains(@class, 'cb-col-16 cb-col text-bold cb-mnth ')]")
	private List<WebElement> month;

	@FindBy(xpath = "//div[@class='cb-sch-lst-itm']")
	private List<WebElement> matchdetail;

	public AustraliaSchedulePage() {

		PageFactory.initElements(driver, this);

	}

	public void secondScenario_writedata() {

	}

}
