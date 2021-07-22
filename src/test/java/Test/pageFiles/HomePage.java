package Test.pageFiles;

import java.util.Properties;

import Test.functionLibrary.CommonMethods;

public class HomePage {
	
	
	CommonMethods comMethods=new CommonMethods();
	Properties prop=CommonMethods.readPropertiesFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\reposirory.properties");
	
	public void selectDepartureCity(String value) {
		
		comMethods.selectFromDropDown(prop.getProperty("Departure"), value);
		
	}
	
	public void verifyDepartureCity(String[] value) {
		
		comMethods.verifyDropDownValues(prop.getProperty("Departure"), value);
		
	}
	
	public void verifyDestinationCity(String[] value) {
		
		comMethods.verifyDropDownValues(prop.getProperty("Destination"), value);
		
	}
	
	public void selectDestinationCity(String value) {
		
		comMethods.selectFromDropDown(prop.getProperty("Destination"), value);
		
	}
	
	public void clickFindFlight() {
		
		comMethods.click(prop.getProperty("FindFlight"));
		
	}
	
	
	public void isHeaderDisplyed() {
		
		comMethods.checkDisplayed(prop.getProperty("HomePageHeader"));
		
	}

}

