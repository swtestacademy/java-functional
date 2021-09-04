package functional.stream.examples;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StreamSeleniumExamples {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.swtestacademy.com");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void swTestAcademyHomePageLinksTest() {
        List<String> homePageLinks = driver.findElements(By.tagName("a"))
            .stream()
            .map(element -> element.getAttribute("href"))
            .filter(link -> !link.isEmpty()) //filter the non-empty links.
            .distinct() //remove duplicate links
            .collect(Collectors.toList()); //collect them to a list
        System.out.println("Homepage link count: " + homePageLinks.size());
        System.out.println("Homepage links: " + homePageLinks);
        Assertions.assertTrue(homePageLinks.size() > 0);
    }
}
