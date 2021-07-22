package Test.pageFiles;

import java.util.Properties;

import Test.functionLibrary.CommonMethods;

public class SearchPage {
	
	CommonMethods comMethods=new CommonMethods();
	Properties prop=CommonMethods.readPropertiesFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\reposirory.properties");
	
	public void isHeaderDisplyed() {
		
		comMethods.checkDisplayed(prop.getProperty("SearchResultHeader"));
		
	}
	
	public void clickFirstFlight() {
		
		comMethods.click(prop.getProperty("FirstFlight"));
		
	}
	
	public void isSearchTableHeaderDisplayed() {
		
		comMethods.checkDisplayed(prop.getProperty("SearchResultTableHeader"));
		
	}
	
	public void isSearchDataDisplayed() {
		
		comMethods.checkDisplayed(prop.getProperty("SearchResultTableData"));
		
	}
	
}
