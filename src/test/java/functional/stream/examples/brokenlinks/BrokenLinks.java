package functional.stream.examples.brokenlinks;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
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
    public void swTestAcademyHomePageBrokenLinksTest1() {
        driver.findElements(By.tagName("a"))
            .stream()
            .parallel() //For parallel execution to process faster.
            .limit(3) //Do the operation for first 3 elements.
            .map(element -> element.getAttribute("href")) //Get the links.
            .filter(link -> !link.isEmpty()) //Filter the non-empty links.
            .distinct() //Remove duplicate links.
            .forEach(link -> System.out.println("Response Code: " + HTTPConnectionUtil.getResponseCode(link) + " Link: " + link));
    }

    @Test
    public void swTestAcademyHomePageBrokenLinksTest2() {
        long count = driver.findElements(By.tagName("a"))
            .stream()
            .parallel()
            .limit(3)
            .map(element -> element.getAttribute("href"))
            .filter(link -> !link.isEmpty()) //filter the non-empty links.
            .distinct() //remove duplicate links
            .filter(link -> (HTTPConnectionUtil.getResponseCode(link) != 200 && HTTPConnectionUtil.getResponseCode(link) != 301))
            .peek(link -> System.out.println("Link: " + link + " Response Code: " + HTTPConnectionUtil.getResponseCode(link)))
            .count();

        Assertions.assertFalse(count > 0);
    }

    @Test
    public void swTestAcademyHomePageBrokenLinksTest3() {
        boolean result = driver.findElements(By.tagName("a"))
            .stream()
            .parallel()
            .limit(3)
            .map(element -> element.getAttribute("href"))
            .filter(link -> !link.isEmpty()) //filter the non-empty links.
            .distinct() //remove duplicate links
            .peek(link -> System.out.println("Link: " + link + " Response Code: " + HTTPConnectionUtil.getResponseCode(link)))
            .anyMatch(link -> (HTTPConnectionUtil.getResponseCode(link) != 200 && HTTPConnectionUtil.getResponseCode(link) != 301));

        Assertions.assertFalse(result);
    }

    @Test
    public void swTestAcademyHomePageBrokenLinksTest4() {
        List<String> brokenLinkList = driver.findElements(By.tagName("a"))
            .stream()
            .parallel()
            .limit(3)
            .map(element -> element.getAttribute("href"))
            .filter(link -> !link.isEmpty()) //filter the non-empty links.
            .distinct() //remove duplicate links
            .filter(link -> HTTPConnectionUtil.getResponseCode(link) != 200 && HTTPConnectionUtil.getResponseCode(link) != 301)
            .collect(Collectors.toList());

        Assertions.assertFalse(brokenLinkList.size() > 0, brokenLinkList.toString());
    }
}
