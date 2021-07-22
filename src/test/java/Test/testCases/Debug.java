package Test.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Debug {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
	      XSSFSheet ExcelWSheet;
	    
	      XSSFWorkbook ExcelWBook;

	      XSSFCell Cell;
		
		 File file=new File("C:\\work\\TestUIAndAPI\\src\\test\\resources\\APITestData.xlsx");
		  FileInputStream ExcelFile = new FileInputStream(file);
		  
		  ExcelWBook = new XSSFWorkbook(ExcelFile);
		  
		  ExcelWSheet = ExcelWBook.getSheet("APITest");
		  Cell = ExcelWSheet.getRow(1).getCell(1);
			
	      String CellData = Double.toString(Cell.getNumericCellValue());
	
	     System.out.println(CellData);

	}

}
