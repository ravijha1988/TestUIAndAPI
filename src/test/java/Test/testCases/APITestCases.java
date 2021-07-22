package Test.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test.functionLibrary.CommonMethods;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

public class APITestCases  extends AbstractTestCases{
	
	@Test
	public void tcApi_1() throws Exception {
	
		//CommonMethods.setExcelFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\TestData.xlsx","APITest");
		//String strTemp =CommonMethods.getCellData(1, 1);
		 given().
		    when().
		        get(APIUrl).
		    then().
		        assertThat().
		        statusCode(200).
		    and().
		        contentType(ContentType.JSON);
		
	}
	
	@Test
	public void tcApi_2() throws Exception {
	
		CommonMethods.setExcelFile("C:\\work\\TestUIAndAPI\\src\\test\\resources\\APITestData.xlsx","APITest");
		String strfairings =CommonMethods.getIntCellData(1,1);
		String strlinks =CommonMethods.getIntCellData(1,2);
		String strid =CommonMethods.getCellData(1,3);
		String strships =CommonMethods.getIntCellData(1,4);
		String strname =CommonMethods.getCellData(1,5);
		String strlinkspatchsmall =CommonMethods.getCellData(1,6);
			
		Response response = RestAssured.get(APIUrl);		
		String jsonString = response.asString();
		java.util.LinkedHashMap<String,String> strTempMap = JsonPath.from(jsonString).get("fairings");
        Assert.assertEquals(String.valueOf(strTempMap.size()), strfairings);
        strTempMap = JsonPath.from(jsonString).get("links");
        Assert.assertEquals(String.valueOf(strTempMap.size()), strlinks);
        String strTempString = JsonPath.from(jsonString).get("id");
        Assert.assertEquals(strTempString, strid);
        java.util.ArrayList<String> strTempArrayist = JsonPath.from(jsonString).get("ships");
        Assert.assertEquals(String.valueOf(strTempArrayist.size()), strships);
        strTempString = JsonPath.from(jsonString).get("name");
        Assert.assertEquals(strTempString, strname);
        strTempString = JsonPath.from(jsonString).get("links.patch.small");
        Assert.assertEquals(strTempString, strlinkspatchsmall);		
	}
	
	@Test
	public void tcApi_3() throws Exception {
	
		 given().
		    when().
		        get(APIUrl).
		    then().
		        assertThat().
		        statusCode(200).
		    and().
		        time(org.hamcrest.Matchers.lessThan(3000L));
		 
	}

}
