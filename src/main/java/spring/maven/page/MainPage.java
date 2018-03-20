package spring.maven.page;

import org.springframework.stereotype.Component;

@Component
public class MainPage extends AbstractPage {

    public MainPage() {
        super("/features");
    }
}