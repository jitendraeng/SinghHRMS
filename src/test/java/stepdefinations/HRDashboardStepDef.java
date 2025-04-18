package stepdefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HRDashboardPage;
import pages.LoginPage;

public class HRDashboardStepDef {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HRDashboardPage hrDashboardPage;

	@Given("User already logged in to aplication")
	public void user_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> credlist = dataTable.asMaps();
		String emaiId = credlist.get(0).get("Emailid");
		String pass = credlist.get(0).get("password");
		DriverFactory.getDriver().get("https://hrmsdev.testinguat.com/login");

		hrDashboardPage = loginPage.doLogin(emaiId, pass);

	}

	@Given("User is on HR dashboard page")
	public void user_is_on_hr_dashboard_page() {
		hrDashboardPage.hrDashboardpageTitle();
		System.out.println("user is on hr dashboard page ");

	}

	@When("user get the page title")
	public void user_get_the_page_title() {
		title = hrDashboardPage.hrDashboardpageTitle();
		System.out.println("HR Dashboard page title is " + title);
	}

	@Then("User get the page title {string}")
	public void user_get_the_page_title(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("user get dashboard section")
	public void user_get_dashboard_section(DataTable expectedSectionTable) {
		List<String> ExpectdsectionList = expectedSectionTable.asList();
		System.out.println("Expected dashboard section list " + ExpectdsectionList);
		List<String> actualSectionList = hrDashboardPage.dashboardSectionList();
		System.out.println("Actual  dashboard section list " + actualSectionList);
		Assert.assertTrue(ExpectdsectionList.containsAll(actualSectionList));

	}

	@Then("Dashboard section count is {int}")
	public void dashboard_section_count_is(Integer expectedCount) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(hrDashboardPage.dashboardSectioncount() == expectedCount);

	}

}
