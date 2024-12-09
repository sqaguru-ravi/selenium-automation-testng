package testcases;

import java.util.Map;

import org.testng.annotations.Test;

import framework.BaseTest;
import framework.JsonDataProvider;
import framework.JsonFilePath;
import pages.ElementsTextBoxFomPage;
import pages.HomePage;

public class ElementsTextboxFormSubmitTest extends BaseTest {

	// XRAYT-19
	// @Test
	// public void verifyTexBoxFormSubmitTest() {
	// 	setJiraTestKey("QDA1-11");

	// 	getExtentTest().info("Test execution started");

	// 	HomePage homePage = new HomePage(getDriver());

	// 	homePage.navigateToElementPage();

	// 	ElementsTextBoxFomPage elementsTextBoxFomPage = new ElementsTextBoxFomPage(getDriver());

	// 	String DataUserName = "Santosh";
	// 	String DataEmail = "santosh@sqaguru.co.in";
	// 	String DataPassword = "santosh123";

	// 	elementsTextBoxFomPage.typeUserName(DataUserName);

	// 	elementsTextBoxFomPage.typePassword(DataPassword);

	// 	elementsTextBoxFomPage.typeEmail(DataEmail);

	// 	elementsTextBoxFomPage.clickSubmitButton();

	// 	elementsTextBoxFomPage.verifyUserNameSubmitted(DataUserName);

	// 	elementsTextBoxFomPage.verifyEmailSubmitted(DataEmail);

	// 	elementsTextBoxFomPage.verifyPasswordSubmitted(DataPassword);

	// 	elementsTextBoxFomPage.verifySubmitAnotherResponseLink();
	// 	getExtentTest().pass("Form submission and verification successful");
	// }

	@Test(dataProvider = "jsonDataProvider", dataProviderClass = JsonDataProvider.class)
    @JsonFilePath("src/test/resources/testdata/dataProviderFormTest.json")
	public void dataProviderFormTest(Map<String, Object> data) {
		setJiraTestKey("");

		getExtentTest().info("Test execution started");

		HomePage homePage = new HomePage(getDriver());

		homePage.navigateToElementPage();

		ElementsTextBoxFomPage elementsTextBoxFomPage = new ElementsTextBoxFomPage(getDriver());

		String DataUserName = (String) data.get("username");
		String DataEmail = (String) data.get("email");
		String DataPassword =(String) data.get("password");
		System.out.println("test001");
		Map<String, String> address = (Map<String, String>) data.get("address");
		System.out.println(address);
		System.out.println(address.get("country"));
		

		elementsTextBoxFomPage.typeUserName(DataUserName);

		elementsTextBoxFomPage.typePassword(DataPassword);

		elementsTextBoxFomPage.typeEmail(DataEmail);

		elementsTextBoxFomPage.clickSubmitButton();

		elementsTextBoxFomPage.verifyUserNameSubmitted(DataUserName);

		elementsTextBoxFomPage.verifyEmailSubmitted(DataEmail);

		elementsTextBoxFomPage.verifyPasswordSubmitted(DataPassword);

		elementsTextBoxFomPage.verifySubmitAnotherResponseLink();
		getExtentTest().pass("Form submission and verification successful");
	}
}
