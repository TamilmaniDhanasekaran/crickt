package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Tamilmani Dhanasekaran
 * 
 *         find the elements in the schedule page and initialization
 * 
 */

public class CricbuzzSchedulePages extends CricbuzzHomePage {

	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileOutputStream fos;
	public static XSSFRow row1;
	public static String filePath = "/Users/dtm/Desktop/cricbuzzUI/src/test/java/com/TestData/DTM_Cricbuzz.xlsx";

	public CricbuzzSchedulePages() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/h1[@class='cb-schdl-hdr cb-font-24 line-ht30']")
	static WebElement header;

	@FindBy(xpath = "//div[@class='cb-lv-grn-strip text-bold'][not(contains(text(),'SAT'))]")
	static List<WebElement> withoutSat;


	/**
	 * @param withoutSat
	 * @throws Exception
	 */
	public void scheduleMatch_writeData() throws Exception {
		src = new File(filePath);
		fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.createSheet("Schedule Matches");

		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);

		XSSFRow row0 = sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue(header.getText());
		sheet.getRow(0).getCell(0).setCellStyle(style);
		int b = 1;
		for (int i = 0; i < withoutSat.size(); i++) {

			String nonSatMatch = withoutSat.get(i).getText();
			String tourName;
			String tourTeamName;
			String tourTime;
			int a = 1;
			row0 = sheet.createRow(b);
			sheet.getRow(b).createCell(0).setCellValue(nonSatMatch);
			sheet.getRow(b).getCell(0).setCellStyle(style);
			while (true) {
				int m = 0;
				row1 = sheet.createRow(++b);

				try {
					
					tourName = driver.findElement(By.xpath("(//div[@class='cb-lv-grn-strip text-bold']" + "[text()='"
							+ nonSatMatch + "']/following-sibling::div/a)[" + a + "]")).getText();
					sheet.getRow(b).createCell(m++).setCellValue(tourName);

					tourTeamName = driver.findElement(By.xpath("//div[@class='cb-lv-grn-strip text-bold']" + "[text()='"
							+ nonSatMatch + "']/following-sibling::div[" + a + "]/div/div")).getText();
					sheet.getRow(b).createCell(m++).setCellValue(tourTeamName);

					tourTime = driver.findElement(By.xpath("//div[@class='cb-lv-grn-strip text-bold']" + "[text()='"
							+ nonSatMatch + "']/following-sibling::div[" + a + "]/div/div[2]")).getText();
					sheet.getRow(b).createCell(m++).setCellValue(tourTime);
					a++;
				} catch (Exception e) {
					break;

				}

			}
		}

		fos = new FileOutputStream(src);
		workbook.write(fos);
		workbook.close();

	}

}

