package com.tyss.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Nirmala
 *
 */
public class ExcelUtilities {
/**
 * To retrive values from Excel
 * @param sheetname
 * @param rowNumber
 * @param cellNumber
 * @return
 * @throws EncryptedDocumentException
 * @throws FileNotFoundException
 * @throws IOException
 */
	
public String getDataFromExcel(String sheetname,int rowNumber,int cellNumber) throws EncryptedDocumentException, FileNotFoundException, IOException
{
	Workbook workbook=WorkbookFactory.create(new FileInputStream(IConstants.excelPath));
	Sheet sheet=workbook.getSheet(sheetname);
	Row row=sheet.getRow(rowNumber);
	Cell cell=row.getCell(cellNumber);
	DataFormatter dataformatter=new DataFormatter();
	String value=dataformatter.formatCellValue(cell);
	return value;
}
/**
 * To insert the data into the Excel
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 * @param data
 * @throws EncryptedDocumentException
 * @throws FileNotFoundException
 * @throws IOException
 */
public void insertIntoExcel(String sheetName,int rowNumber,int cellNumber,String data) throws EncryptedDocumentException, FileNotFoundException, IOException
{
	Workbook workbook=WorkbookFactory.create(new FileInputStream(IConstants.excelPath));
	Sheet sheet=workbook.getSheet(sheetName);
	Row row=sheet.getRow(rowNumber);
	Cell cell=row.getCell(cellNumber);
	cell.setCellValue(data);
	FileOutputStream fileoutputstream=new FileOutputStream(IConstants.excelPath);
	workbook.write(fileoutputstream);
	
}
/**
 * To get the lastRow
 * @param sheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws FileNotFoundException
 * @throws IOException
 */
public int getLastRowNumFromExcel(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException
{
	Workbook workbook=WorkbookFactory.create(new FileInputStream(IConstants.excelPath));
	Sheet sheet=workbook.getSheet(sheetName);
	int row=sheet.getLastRowNum();
	return row;
	
}

}
