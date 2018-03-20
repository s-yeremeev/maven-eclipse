package spring.maven.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("spring.maven")
public class SpringConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		Properties properties = new Properties();
		properties.setProperty("server.url", "https://github.com/");
		properties.setProperty("webDriver.quitAfterTests", "false");
		properties.setProperty("webDriver.browser.width", "1800");
		properties.setProperty("webDriver.browser.height", "900");

		PropertySourcesPlaceholderConfigurer result = new PropertySourcesPlaceholderConfigurer();
		result.setProperties(properties);
		return result;
	}

}
