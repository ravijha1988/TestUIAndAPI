package Test.functionLibrary;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	
	private static WebDriver driver;
    private static XSSFSheet ExcelWSheet;
    
    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;
    
    
	
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}
	
	public static void breakDown() {
		driver.close();
		driver.quit();
	}
	
	public void navigateToUrl(String url)
	{
		driver.get(url);
	}
	
	public static Properties readPropertiesFile(String fileName){
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	         fis.close();
	      } catch(FileNotFoundException fne) {
	         fne.printStackTrace();
	      } catch(IOException e) {
	         e.printStackTrace();
	      } finally {
	    	  try{fis.close();}catch(IOException e) {
	 	         e.printStackTrace();
		      }
	      }
	      return prop;
	   }
	
	
	
	public void selectFromDropDown(String xPath,String value)
	{
		try {
			Select se = new Select(driver.findElement(By.xpath(xPath)));
			se.selectByValue(value);	
		}catch(ElementNotInteractableException enf) {
			enf.printStackTrace();
	      } 		
	}
	
	public void verifyDropDownValues(String xPath,String[] value)
	{
		try {
			Select se = new Select(driver.findElement(By.xpath(xPath)));
			List<WebElement> options=se.getOptions();
			for(int i=0; i<options.size(); i++) {
				Assert.assertEquals(options.get(i).getText(), value[i]);
			}
		}catch(ElementNotInteractableException enf) {
			enf.printStackTrace();
	      } 		
	}
	
	public void setValue(String xPath,String value)
	{
		try {
			WebElement webEle = driver.findElement(By.xpath(xPath));							
			webEle.sendKeys(value);	
		}catch(ElementNotInteractableException enf) {
			enf.printStackTrace();
	      } 		
	}
	
	public void verifyTableData(String xPath,String value)
	{
		String temp="";
		try {
			temp = driver.findElement(By.xpath(xPath)).getText();						
			Assert.assertEquals(value, temp);	
		}catch(ElementNotInteractableException enf) {
			enf.printStackTrace();
	      } 		
	}
	
	public void click(String xPath)
	{
		try {
			WebElement webEle = driver.findElement(By.xpath(xPath));							
			webEle.click();
		}catch(ElementNotInteractableException enf) {
			enf.printStackTrace();
	      } 		
	}
	
	public boolean checkEnabled(String xPath)
	{
		boolean flag=false;
		try {
			driver.findElement(By.xpath(xPath)).isEnabled();
		}catch(ElementNotInteractableException enf) {
			enf.printStackTrace();
	      } 
		return flag;
	}
	
	public boolean checkDisplayed(String xPath)
	{
		boolean flag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xPath))));
			flag=driver.findElement(By.xpath(xPath)).isDisplayed();
		}catch(ElementNotInteractableException enf) {
			enf.printStackTrace();
	      } 
		return flag;
	}
	
	public String getText(String xPath,String Value)
	{
		String temp="";
		try {
			temp=driver.findElement(By.xpath(xPath)).getAttribute(Value);
		}catch(ElementNotInteractableException enf) {
			enf.printStackTrace();
	      } 
		return temp;
	}
	
    public static void setExcelFile(String Path,String SheetName) throws Exception {
    	 
        try {		
        		  File file=new File(Path);
				  FileInputStream ExcelFile = new FileInputStream(file);
				  
				  ExcelWBook = new XSSFWorkbook(ExcelFile);
				  
				  ExcelWSheet = ExcelWBook.getSheet(SheetName);
			  
			  } catch (Exception e){
			  
				  throw (e);
			  
			  }
  
  }
    
    public static String getCellData(int RowNum, int ColNum) throws Exception{
    	 
	  try{
	
	      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	
	      String CellData = Cell.getStringCellValue();
	
	      return CellData;
	
	      }catch (Exception e){
	    	  	return"";
	      }

    }   
    
    
    public static String getIntCellData(int RowNum, int ColNum) throws Exception{
   	 
	  try{
	
	      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	
	      String CellData = String.valueOf((int) Cell.getNumericCellValue());
	
	      return CellData;
	
	      }catch (Exception e){
	    	  	return"";
	      }

    } 
    
}
