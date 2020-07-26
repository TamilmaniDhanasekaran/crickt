package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveScorePage extends CricbuzzHomePage {

	public LiveScorePage() {

		PageFactory.initElements(driver, this);
	}

	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileOutputStream fos;
	public static FileOutputStream fos1;
	public static FileOutputStream fos2;
	public static FileOutputStream fos3;
	public static FileOutputStream fos4;
	public static XSSFRow row1;
	public static XSSFRow row0;
	public static XSSFRow row2;
	public static XSSFRow row3;
	public static XSSFRow row4;
	public static XSSFRow row5;

	public static String filePath = "/Users/dtm/Desktop/cricbuzzUI/src/test/java/com/TestData/DTM_Cricbuzz.xlsx";
	static String header = "Cricket Schedule - INTERNATIONAL";

	public static String countryToVerify = "Australia";

	@FindBy(xpath = "(//a[@class='cb-text-link cb-mtch-lnks'])[2]")
	public static WebElement scorecard;

	@FindBy(className = "cb-col cb-col-27")
	public List<WebElement> batsman;

//	@FindBy(xpath = "//div[@class='cb-col cb-col-100 cb-scrd-itms']")
//	List<WebElement> listBatsman;
//
//	@FindBy(xpath = "//div[@class='cb-col cb-col-27 text-bold']")
//	List<WebElement> currentBatting;

	@FindBy(className = "cb-col cb-col-100 cb-scrd-hdr-rw")
	List<WebElement> inningsCountry;

	@FindBy(xpath = "//div[@class='cb-col cb-scrcrd-status cb-col-100 cb-text-live ng-scope']")
	WebElement subtitle;

	@FindBy(className = "cb-nav-hdr cb-font-18 line-ht24")
	WebElement mainHeader;

	// new
	@FindBy(className = "cb-col cb-col-27 ")
	static List<WebElement> finalBatsmanList;

	@FindBy(xpath = "//div[@class='cb-col cb-col-33']")
	static List<WebElement> finalTakenBy;

	@FindBy(className = "cb-col cb-col-8 text-right text-bold")
	List<WebElement> finalRun;

	@FindBy(xpath = "//div[@class='cb-col cb-col']")
	static List<WebElement> finalAll;

	@FindBy(xpath = "(//div[contains(text(),'Batsman')])[2]")
	static WebElement batsmanHeader;

	@FindBy(xpath = "//div[@class='cb-col cb-col-8 text-right text-bold']")
	static List<WebElement> runValues;

	@FindBy(className = "cb-col cb-col-8	text-right")
	static WebElement sixValue;

	// recent
	@FindBy(xpath = "//h1[@class='cb-nav-hdr cb-font-18 line-ht24']")
	static WebElement h1Header;

	@FindBy(xpath = "//div[@class='cb-nav-subhdr cb-font-12']")
	static WebElement venueHeader;

	@FindBy(xpath = "(//div[@class='cb-col cb-col-100 cb-scrd-hdr-rw'])[1]")
	static WebElement h2Header;

	@FindBy(xpath = "(//div[@class='cb-col cb-col-8 text-right text-bold'])[1]")
	static WebElement runHeader;

	@FindBy(xpath = "//div[@class='cb-col cb-col-8 text-right']")
	static List<WebElement> runnerHead;

	@FindBy(xpath = "//div[@class='cb-col cb-col-27 ']")
	static List<WebElement> batsmanList;

	public static void writeLiveScore(WebElement head1, WebElement head2) throws Exception {

		src = new File(filePath);
		fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.createSheet("Scenario3_Score");
		char flag = 'y';
		int i = 4;
		int k = 4;
		int z = 4;
		int m = 3;

		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		row0 = sheet.createRow(0);
		row1 = sheet.createRow(1);
		row2 = sheet.createRow(2);
		row3 = sheet.createRow(3);
		row4 = sheet.createRow(4);

		row0.createCell(0).setCellValue(h1Header.getText());
		row1.createCell(0).setCellValue(venueHeader.getText());
		row2.createCell(0).setCellValue(h2Header.getText());
		row3.createCell(0).setCellValue(batsmanHeader.getText());
		row3.createCell(1).setCellValue("    ");
		row3.createCell(2).setCellValue(runHeader.getText());

		row0.getCell(0).setCellStyle(style);
		row1.getCell(0).setCellStyle(style);
		row2.getCell(0).setCellStyle(style);
		row3.getCell(2).setCellStyle(style);
		

		// loop to write run header
			if (flag=='y') {
			for (int p = 0; p < 4; p++) {

				String runHead = runnerHead.get(p).getText();
				System.out.println("runHead: " + runHead);
				row3.createCell(m).setCellValue(runHead);
				m++;
//				fos = new FileOutputStream(src);
			}

//
//		
			// loop for wickets taken by

			System.out.println("one loop over");

			for (int j = 1; j <= 11; j++) {

				row4 = sheet.createRow(k);
				XSSFRow row5 = sheet.createRow(k + 1);

				String takenBy = finalTakenBy.get(j).getText();
				System.out.println("takenBy: " + takenBy);
				row4.createCell(1).setCellValue(takenBy);
				sheet.getRow(k + 1).createCell(1).setCellValue(takenBy);
				k++;
//				fos2 = new FileOutputStream(src);
			}

			// workbook.write(fos2);

			System.out.println("second loop over");

			// loop for runs

			for (int j = 1; j <= 10; j++) {

				row4 = sheet.createRow(z);
				XSSFRow row5 = sheet.createRow(z + 1);

				String runBy = runValues.get(j).getText();
				System.out.println("RUN: " + runBy);
				row4.createCell(2).setCellValue(runBy);
				sheet.getRow(z + 1).createCell(2).setCellValue(runBy);
				z++;
//				fos3 = new FileOutputStream(src);

			}

			// loop to write batsmanList
			for (int j = 0; j <= 10; j++) {

				row4 = sheet.createRow(i);
				XSSFRow row5 = sheet.createRow(i + 1);

				String batsman = batsmanList.get(j).getText();
				System.out.println("batsman: " + batsman);
				row4.createCell(0).setCellValue(batsman);
				sheet.getRow(i + 1).createCell(0).setCellValue(batsman);
				i++;
//				fos1 = new FileOutputStream(src);
			}

	
		}
		fos = new FileOutputStream(src);
		workbook.write(fos);
//		workbook.write(fos1);
//		workbook.write(fos2);
//		workbook.write(fos3);

//		workbook.close();
		fos.close();
//		fos1.close();
//		fos2.close();
//		fos3.close();

	}

	public static void getScoreCard() throws Exception {

		writeLiveScore(h1Header, venueHeader);
//		src = new File(filePath);
//		fis = new FileInputStream(src);
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.createSheet("Scenario3_Score");
//
//		XSSFCellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		style.setFont(font);
//
//		row0 = sheet.createRow(0);
//		row1 = sheet.createRow(1);
//		row2 = sheet.createRow(2);
//		row3 = sheet.createRow(3);
//		row4 = sheet.createRow(4);
//
//		row0.createCell(0).setCellValue(h1Header.getText());
//		row1.createCell(0).setCellValue(venueHeader.getText());
//		row2.createCell(0).setCellValue(h2Header.getText());
//		row3.createCell(0).setCellValue(batsmanHeader.getText());
//		row3.createCell(1).setCellValue("    ");
//		row3.createCell(2).setCellValue(runHeader.getText());
//
//		row0.getCell(0).setCellStyle(style);
//		row1.getCell(0).setCellStyle(style);
//		row2.getCell(0).setCellStyle(style);
//		row3.getCell(2).setCellStyle(style);
//
//		
//		int k = 4;
//		int z = 4;
//		int m = 3;
//
//		// loop to write run header
//
//
//			for (int p = 0; p < 4; p++) {
//
//				String runHead = runnerHead.get(p).getText();
//				System.out.println("runHead: " + runHead);
//				row3.createCell(m).setCellValue(runHead);
//				m++;
//				fos = new FileOutputStream(src);
//			}
//
//		write_score(batsmanList, 4, 0);
//		write_score(finalTakenBy, 4, 1);
//		write_score(runValues, 4, 2);
//		writeBatsMan();

	}

	public static void write_score(List<WebElement> valueToWrite,int rowNumber,int cellNumber) throws IOException {

		//
//		fis = new FileInputStream(src);
//		workbook = new XSSFWorkbook(fis);
//		sheet = workbook.createSheet("Scenario3_Score");
//
//		XSSFCellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		style.setFont(font);
//
//		row0 = sheet.createRow(0);
//		row1 = sheet.createRow(1);
//		row2 = sheet.createRow(2);
//		row3 = sheet.createRow(3);
//		row4 = sheet.createRow(4);
//
//		row0.createCell(0).setCellValue(h1Header.getText());
//		row1.createCell(0).setCellValue(venueHeader.getText());
//		row2.createCell(0).setCellValue(h2Header.getText());
//		row3.createCell(0).setCellValue(batsmanHeader.getText());
//		row3.createCell(1).setCellValue("    ");
//		row3.createCell(2).setCellValue(runHeader.getText());
//
//		row0.getCell(0).setCellStyle(style);
//		row1.getCell(0).setCellStyle(style);
//		row2.getCell(0).setCellStyle(style);
//		row3.getCell(2).setCellStyle(style);
		int i = 4;

			// loop to write batsmanList
			for (int j = 0; j <= 10; j++) {

				row4 = sheet.createRow(rowNumber);
				XSSFRow row5 = sheet.createRow(rowNumber + 1);

				String value = valueToWrite.get(j).getText();
				System.out.println("value: " + value);
				row4.createCell(cellNumber).setCellValue(value);
				sheet.getRow(rowNumber + 1).createCell(cellNumber).setCellValue(value);
				i++;
				fos1 = new FileOutputStream(src);
			}

		System.out.println("am done!!!!1");
		workbook.write(fos);
		workbook.write(fos1);
		

	}

	public static void clickRecent() throws InterruptedException {

		recent.click();
		Thread.sleep(2000);

	}

	public void clickScorecard() throws Exception {

		scorecard.click();
		Thread.sleep(2000);
//		for (int i = 0; i <= 1; i++)
//
//		{
//			js = (JavascriptExecutor) driver;
//			Thread.sleep(500);
//			js.executeScript("window.scrollBy(0,10000)");
//			Thread.sleep(500);
//		}

	}
}
