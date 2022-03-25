package stepDefinitions;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import Utilities.CommonMethods;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LabCropTest extends CommonMethods{
	
	@Given("A user navigates to careers tab")
	public void a_user_navigates_to_careers_tab() {
		ComP.CareersTab.click();
	}

	@When("A user is able to search any position and verify the title")
	public void a_user_is_able_to_search_any_position_and_verify_the_title() {
		CommonMethods.switchToChildWindow();
        CarP.SearchField.sendKeys(ConfigurationReader.getProperty("keys"));
        CarP.SearchField.sendKeys(Keys.ENTER);
        CommonMethods.wait(3);
        String ActualResult = CarP.TextMassage.getText();
        String ExpectResult = "Test Automation Engineer/Jr. Software Developer";
        Assert.assertEquals(ActualResult, ExpectResult);
        CarP.TextMassage.click();

		
	    	}

	@When("A user successfully verify description responsibilities requirements")
	public void a_user_successfully_verify_description_responsibilities_requirements() {
        String DesPart1 = CarP.Description1stSentense.getText();

        String ActualResult = DesPart1.substring(0, 105);
        String ExpectResult = "LabCorp is seeking a Test Automation Engineer/Jr. Software Developer for its Burlington, NC headquarters.";
        Assert.assertEquals(ActualResult, ExpectResult);

        String ActualResult1 = CarP.responsibilities2rdBullet.getText();
        String ExpectResult1 = "Perform manual testing as needed to understand application processes and workflows in order to convert into automated test scripts.";
        Assert.assertEquals(ActualResult1, ExpectResult1);

        String ActualResult2 = CarP.requirements.getText();
        String ExpectResult2 = "5-7 years hands-on test automation or development experience.";
        Assert.assertEquals(ActualResult2, ExpectResult2);

        }
   
	

	@When("A user successfully apply for the position")
	public void a_user_successfully_apply_for_the_position() {
        CarP.ApplyButton.click();
  
	}

	@Then("A user successfully verify a job title match the previous page")
	public void a_user_successfully_verify_a_job_title_match_the_previous_page() {
        String main2 = Driver.getDriver().getWindowHandle();
        Set<String> windows2 = Driver.getDriver().getWindowHandles();
        for (String window3 : windows2) {
            if (!window3.equals(main2)) {
                Driver.getDriver().switchTo().window(window3);
                break;
            }

        }

        String title = getDriver().getTitle();
        System.out.println("Title is "+ title);

        String ActualResult = CarP.JobTitle.getText();
        String ExpectResult = "Test Automation Engineer/Jr. Software Developer";
        Assert.assertEquals(ActualResult, ExpectResult);

       CarP.ReturnToJobSerchButton.click();
  
	}


}
