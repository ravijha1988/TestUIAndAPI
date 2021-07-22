package Test.testCases;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Test.functionLibrary.CommonMethods;

public class BasicTestCases extends AbstractTestCases{
	
	/*
	 1. Verify if user is able to book flight successfully on proper inputs for source and destination city. <Automated>
	 2. Verify as to what destinations,sources and payment options, are available to user. Should be wide variety to choose from.<Automated>
	 3. Verify if search results/Flight booking confirmation are displayed within stipulated time (quick response).
	 4. Verify if user gets error when invalid inputs like number/same value are provided as inputs in source and destination city.
	 5. Verify if auto suggestions are working in input text fields when initials are typed.
	 */
	
	@Test
	public void tc_1() throws Exception {
	
		CommonMethods.setExcelFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\TestData.xlsx","SmokeTest");
		String strDeparture =CommonMethods.getCellData(1, 1);
		String strDestination =CommonMethods.getCellData(1, 2);
		String strName =CommonMethods.getCellData(1, 3);
		String strAddress =CommonMethods.getCellData(1, 4);
		String strCity =CommonMethods.getCellData(1, 5);
		String strState =CommonMethods.getCellData(1, 6);
		String strZipCode =CommonMethods.getCellData(1, 7);
		String strCardType =CommonMethods.getCellData(1, 8);
		String strCreditCNumber =CommonMethods.getCellData(1, 9);
		String strMonth =CommonMethods.getCellData(1, 10);
		String strYear =CommonMethods.getCellData(1, 11);
		String strNameOnCard=CommonMethods.getCellData(1, 12);
		String strStatus=CommonMethods.getCellData(1, 13);
		CommonMethods.setUp();
		comMethods.navigateToUrl(Url);
		hp.isHeaderDisplyed();
		hp.selectDepartureCity(strDeparture);
		hp.selectDestinationCity(strDestination);
		hp.clickFindFlight();
		sp.isHeaderDisplyed();
		sp.isSearchDataDisplayed();
		sp.isSearchTableHeaderDisplayed();
		sp.clickFirstFlight();
		dp.isHeaderDisplyed();
		dp.setName(strName);
		dp.setAddress(strAddress);
		dp.setZipCode(strZipCode);
		dp.setCity(strCity);
		dp.setState(strState);
		dp.selectCard(strCardType);
		dp.setCreditCardNumber(strCreditCNumber);
		dp.setCreditCardMonth(strMonth);
		dp.setCreditCardYear(strYear);
		dp.setNameOnCard(strNameOnCard);
		dp.clickPurchaseFlight();
		cp.isHeaderDisplyed();
		cp.verifyStatus(strStatus);
		CommonMethods.breakDown();
	}
	
	@Test
	public void tc_2() throws Exception {
	
		CommonMethods.setExcelFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\TestData.xlsx","SmokeTest");
		String[] strDeparture =CommonMethods.getCellData(2, 1).split(";");
		String[] strDestination =CommonMethods.getCellData(2, 2).split(";");
		String[] strCardType =CommonMethods.getCellData(2, 8).split(";");
		CommonMethods.setUp();
		comMethods.navigateToUrl(Url);
		hp.isHeaderDisplyed();
		hp.verifyDepartureCity(strDeparture);
		hp.verifyDestinationCity(strDestination);
		hp.clickFindFlight();
		sp.isHeaderDisplyed();
		sp.clickFirstFlight();
		dp.isHeaderDisplyed();
		dp.verifyCard(strCardType);
		CommonMethods.breakDown();
	}


}
