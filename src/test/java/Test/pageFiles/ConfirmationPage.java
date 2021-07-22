package Test.pageFiles;

import java.util.Properties;

import Test.functionLibrary.CommonMethods;

public class ConfirmationPage {
	
	CommonMethods comMethods=new CommonMethods();
	Properties prop=CommonMethods.readPropertiesFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\reposirory.properties");
	
	public void isHeaderDisplyed() {
		
		comMethods.checkDisplayed(prop.getProperty("ConfHeader"));
		
	}
	public void verifyStatus(String value) {
		
		comMethods.verifyTableData(prop.getProperty("Status"), value);
		
	}

}
