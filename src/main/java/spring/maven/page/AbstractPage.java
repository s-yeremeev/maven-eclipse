package spring.maven.page;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import spring.maven.BaseWebDriverTests;

@Component
public class AbstractPage {

	protected String baseUrl;

	@Value("${server.url}")
	private String startBaseUrl;

	public AbstractPage(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public void open() {
		BaseWebDriverTests.driver.get(startBaseUrl + this.baseUrl);
	}

	public AbstractPage() {
		this("");
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public String getStartBaseUrl() {
		return startBaseUrl;
	}
}
