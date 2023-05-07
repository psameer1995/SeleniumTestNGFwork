package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata{

	//to use the utility in test case we need to remove the main method and 
	//Add the @Dataprovider annotation to use the excel data.
	
	/*
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//to check the code working fine or not.
		//we create a instance/object of getData method and print.
		ReadXLSdata red=new ReadXLSdata();
		red.getData("login");
	}
	*/
	
	
	//Add data provider to utilize in tests.
	@DataProvider(name = "myexceldata")
	
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException
	{
		//to keep the excelsheetname and testcase method name same.
		String excelSheetname = m.getName();
				
		//File class to read the file path
		//Cntrl+shift+O to auto imports
		
		//to navigate till excel file sheet.
		File src = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetname);
		
		//write a logic that able to access all the sheet rows and columns which will add in future data/changes in file(dynamaic changes).
		//first count the rows and columns in a sheet.
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		
		//columns count using row cells.
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		
		
		//format the data in sheet, after getting the counts -using DataFormatter class.
		DataFormatter format = new DataFormatter();
		
		
		//Start iterate through the sheet and read the data
		//to iterate we need nestead for loop (1 to iterate row and 1 to iterate columns)
		
		
		//Note: Create Two dimensional array.
		String testData[][] = new String [totalRows][totalCols];
		
		
		//first for loop int i=1 means in excel sheet we are removing the first row(column headers) and starting from index 1(actual data).
		//second for loop int j=0 means we actually eliminated first row and strating from row2 --first cell as j=0.
		//j<totalCols means we are iterating from o cell and which (iteratingcount)is less that the totalcount (starting from 1, 2....)
		for(int i=1; i<=totalRows; i++) {
			
			for (int j=0; j<totalCols; j++) {
				
				//get the row and cell number and adjust to desired iterate that its  (i-1) means (0,0)
				//that is first cell

				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
				//Create two dimensional string array above to store the getting value from here as variable/obj.	
			}
		}
		
		
		//finally "return" the data- which will helpful in using other methods/tests.
		//if we return data, method should not have void (means) ---null, it should be a not void method.
		return testData;
		
		
		
		
	}

}
