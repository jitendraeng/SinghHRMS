package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ConfigReader;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties props;
	
	@Before(order=0)
	public void getProperty() {
		configReader=new ConfigReader();
		props=configReader.init_props();		
	}

	
	@Before(order=1)
	public void launchBrowser() {
		
		String browserName=props.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();	
	}

	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshoot
		String screenshootName=	scenario.getName().replaceAll(" ", "_");
			
			byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshootName);
		}
	}
}
