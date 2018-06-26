package com.ajay.AdvanceSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static XSSFWorkbook wBook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;

	public static void setExcelPath(String sheetName, String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		wBook = new XSSFWorkbook(fis);
		sheet = wBook.getSheet(sheetName);

	}

	public static String getCellData(int rownum, int colnum) {
		String stringCellData;
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		stringCellData = cell.getStringCellValue();
		return stringCellData;

	}

	public static String[][] getExcelTable() {
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int numOfCols = 2;
		int ci, cj;
		ci = 1;
		cj = 1;
		String[][] excelData = new String[noOfRows][numOfCols];
		for (int i = 0; i < noOfRows; i++, ci++) {
			cj = 1;
			for (int j = 0; j < numOfCols; j++, cj++) {
				excelData[i][j] = getCellData(ci, cj);
			}
		}
		return excelData;
	}

	public static void setExcelData(int rownum, int column, String data) throws IOException {
		row = sheet.getRow(rownum);
		cell = row.getCell(column, MissingCellPolicy.RETURN_BLANK_AS_NULL);
		if (cell == null) {
			cell = row.createCell(column);
			cell.setCellValue(data);
		} else {
			cell.setCellValue(data);
		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\A06438_p5.training\\Desktop\\testdata\\Book1.xlsx");
		wBook.write(fos);
		fos.flush();
		fos.close();
	}

}