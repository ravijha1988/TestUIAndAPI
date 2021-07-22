package Test.testCases;

import java.util.Properties;

import Test.functionLibrary.CommonMethods;
import Test.pageFiles.ConfirmationPage;
import Test.pageFiles.DetailsPage;
import Test.pageFiles.HomePage;
import Test.pageFiles.SearchPage;

public abstract class AbstractTestCases {
	
	protected HomePage hp=new HomePage();
	protected DetailsPage dp=new DetailsPage();
	protected SearchPage sp=new SearchPage();
	protected ConfirmationPage cp=new ConfirmationPage();
	protected CommonMethods comMethods=new CommonMethods();
	protected Properties prop=CommonMethods.readPropertiesFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\env.properties");
	protected String Url=prop.getProperty("TestUIURL");
	protected String APIUrl=prop.getProperty("TestAPIURL");

}
