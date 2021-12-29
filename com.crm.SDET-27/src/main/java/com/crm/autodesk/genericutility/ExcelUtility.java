package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * its used read the data from  org excel base don below arguments 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getDataFromExcel( String sheetName,int rowNum, int celNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws IOException
	 */
	
	
	public int getRowCount(String sheetName) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("./data/Book1.xlsx");
		
		 Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		wb.close();
		return sheet.getLastRowNum();
			
		}
	
	
	public void setDataExcel( String sheetName,int rowNum,int celNum, String data) throws EncryptedDocumentException, IOException {
		 FileInputStream fis = new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.createSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/Book1.xlsx");
		wb.write(fos);
		wb.close();
		

		 
	
	
	}
	
	
	
}