package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	private By emailId = By.xpath("//*[@id=\"floatinginput:r0:\"]");
	private By password = By.xpath("//*[@id=\"floatinginput:r1:\"]");
	private By loginButton = By.xpath("//*[@id=\"root\"]/section/div/div/div[2]/div/div[2]/form/div[5]/button");
	private By forgotPasswordLink = By.xpath("/html/body/div/section/div/div/div[2]/div/div[2]/form/div[4]/a");

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotpasswordLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public void enterUserName(String username) {

		driver.findElement(emailId).sendKeys(username);

	}

	public void enterPassword(String pwd) {

		driver.findElement(password).sendKeys(pwd);

	}
	
	public void clickLoginBtn() {

		driver.findElement(loginButton).click();

	}
	
	public HRDashboardPage doLogin(String un, String pwd) {
		System.out.println("login with "+un +" and"+pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new HRDashboardPage(driver);
		
	}

}
