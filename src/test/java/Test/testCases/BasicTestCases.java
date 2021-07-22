package Test.testCases;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Test.functionLibrary.CommonMethods;

public class BasicTestCases extends AbstractTestCases{
	
	/*
	 1.verify if blazedemo.com is accessible to destined users
	2.verify if welcome message and options to provide input are available
	3.verify the hyperlink below welcome message is not broken
	4.verify if proper search results are displayed on selection of departure and destination city
	5.verify if auto suggestions are working in input text fields when initials are typed
	6.Verify if incorrect inputs like numbers or special characters are provided as input in text boxes then proper error message is displayed
	7. Verify the error message when departure and destination city are input as same.
	8. Verify if error and suggestion is dispayed if no inputs are provided and user clicks on Find Flights
	8.Verify if user is navigated back to home page if it clicks on home from Flights search page.
	9. Verify if the search results on proper input are displayed within seconds to user.
	 
	 
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
