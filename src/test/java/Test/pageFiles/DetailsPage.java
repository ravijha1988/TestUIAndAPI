package Test.pageFiles;

import java.util.Properties;

import Test.functionLibrary.CommonMethods;

public class DetailsPage {
	
	
	
	CommonMethods comMethods=new CommonMethods();
	Properties prop=CommonMethods.readPropertiesFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\reposirory.properties");
	
	public void isHeaderDisplyed() {
		
		comMethods.checkDisplayed(prop.getProperty("EnterDetailsHeader"));
		
	}
	
	public void clickPurchaseFlight() {
		
		comMethods.click(prop.getProperty("PurchaseTicket"));
		
	}
	
	public void setName(String value) {
		
		comMethods.setValue(prop.getProperty("Name"),value);
		
	}
	public void setAddress(String value) {
		
		comMethods.setValue(prop.getProperty("Address"),value);
		
	}
	public void setCity(String value) {
		
		comMethods.setValue(prop.getProperty("City"),value);
		
	}
	public void setState(String value) {
		
		comMethods.setValue(prop.getProperty("State"),value);
		
	}
	public void setZipCode(String value) {
		
		comMethods.setValue(prop.getProperty("ZipCode"),value);
		
	}
	public void selectCard(String value) {
		
		comMethods.selectFromDropDown(prop.getProperty("CardType"),value);
		
	}
	
	public void verifyCard(String[] value) {
		
		comMethods.verifyDropDownValues(prop.getProperty("CardType"),value);
		
	}
	public void setCreditCardNumber(String value) {
		
		comMethods.setValue(prop.getProperty("CreditCardNumber"),value);
		
	}
	public void setCreditCardMonth(String value) {
		
		comMethods.setValue(prop.getProperty("CreditCardMonth"),value);
		
	}
	public void setCreditCardYear(String value) {
		
		comMethods.setValue(prop.getProperty("CreditCardYear"),value);
		
	}
	public void setNameOnCard(String value) {
		
		comMethods.setValue(prop.getProperty("NameOnCard"),value);
		
	}

}
