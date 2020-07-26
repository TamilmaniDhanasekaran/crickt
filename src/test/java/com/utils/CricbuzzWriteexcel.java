package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

/**
 * @author Tamilmani Dhanasekaran
 * 
 *         To write the retrieved data into excel
 *
 */
public class CricbuzzWriteexcel {

	static WebDriver driver;
	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileOutputStream fos;
	public static XSSFRow row1;
	public static XSSFRow row0;

	public static String filePath = "/Users/dtm/Desktop/cricbuzzUI/src/test/java/com/TestData/DTM_Cricbuzz.xlsx";
	static String header = "Cricket Schedule - INTERNATIONAL";
	public static String countryToVerify = "Australia";

	/**
	 * Write australia series method is used to retrieve all the australia matches
	 * and write in excel
	 *
	 * @param month      is the australia series month
	 * @param seriesName is the ausralia series name
	 * @throws Exception the exception
	 */

	public static void writeAustraliaSeries(Map<String, ArrayList<String>> matchWithMonth, ArrayList<String> monthList)
			throws Exception {
		src = new File(filePath);
		fos = new FileOutputStream(src);
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Australia Series");

		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);
		int b = 0;
		row0 = sheet.createRow(b);
		sheet.getRow(0).createCell(0).setCellValue("Month");
		sheet.getRow(0).createCell(1).setCellValue("Series Name");
		sheet.getRow(0).getCell(0).setCellStyle(style);
		sheet.getRow(0).getCell(1).setCellStyle(style);

		for (String monthName : monthList) {
			sheet.createRow(++b);
			sheet.getRow(b).createCell(0).setCellValue(monthName);
			ArrayList<String> tourDetails = matchWithMonth.get(monthName);
			for (String teamDetails : tourDetails) {
				sheet.getRow(b).createCell(1).setCellValue(teamDetails);
				sheet.createRow(++b);
			}
		}

		fos = new FileOutputStream(src);
		workbook.write(fos);
		workbook.close();
	}


}

