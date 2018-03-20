package spring.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import spring.maven.page.MainPage;

public class TestSpring extends BaseWebDriverTests {

	@Autowired
	public MainPage mainPage;

	@Test
	public void t_01() {
		mainPage.open();
	}
}
