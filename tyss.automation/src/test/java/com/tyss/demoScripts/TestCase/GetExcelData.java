package com.tyss.demoScripts.TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;



public class GetExcelData{
	@Test
	public void getExcelData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String path = ".//src/main/resources/data/Naukri_Data.xlsx";
		String sdata[]=null;
		FileInputStream fis =new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("Registration");
		int rowSize=sh.getLastRowNum();
		sdata=new String[rowSize];
		for(int i=0;i<rowSize;i++) {
			Row row=sh.getRow(i);
//			int cellSize=row.getLastCellNum();
			
//			for(int j=0;j<cellSize;j++) {
				Cell cell=row.getCell(1);
				sdata[i]=cell.getStringCellValue();
//				System.out.println(cell.getStringCellValue());
			}
			for(int i=0;i<sdata.length;i++) {
			System.out.println(sdata[i]);
			}
//		}
	}

}
