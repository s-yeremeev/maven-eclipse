package spring.maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import spring.maven.config.SpringConfig;

@Component
@ContextConfiguration(classes = SpringConfig.class)
public class BaseWebDriverTests extends AbstractTestNGSpringContextTests {

	public static WebDriver driver;

	@Value("${webDriver.browser.width}")
	private String browserWidth;

	@Value("${webDriver.browser.height}")
	private String browserHeight;

	@Value("${webDriver.quitAfterTests}")
	private String quitAfterTests;

	@BeforeClass
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "src/chromedriver/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--window-size=" + browserWidth + "," + browserHeight + "");
		driver = new ChromeDriver(option);
	}

	@AfterClass
	public void closeChrome() {
		String quit = getQuitAfterTests();
		if (quit == "true") {
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public String getBrowserWidth() {
		return browserWidth;
	}

	public String getBrowserHeight() {
		return browserHeight;
	}

	public String getQuitAfterTests() {
		return quitAfterTests;
	}

}
