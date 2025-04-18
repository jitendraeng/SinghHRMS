package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HRDashboardPage {

	private WebDriver driver;
	

	private By dashBoardsection = By.xpath("//div[@class='link-item-main']/ul[2]/li");

	public HRDashboardPage(WebDriver driver) {

		this.driver = driver;
	}

	public String hrDashboardpageTitle() {

		return driver.getTitle();

	}

	public int dashboardSectioncount() {

		return driver.findElements(dashBoardsection).size();

	}

	public List<String> dashboardSectionList() {
		List<String> dashboardSectionList = new ArrayList<>();
		List<WebElement> dashboardList = driver.findElements(dashBoardsection);

		for (WebElement e : dashboardList) {

		String	text = e.getText();
			dashboardSectionList.add(text);
		}
		System.out.println(dashboardList);
		return dashboardSectionList;

	}

}
