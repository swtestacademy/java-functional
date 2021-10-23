package functional.stream.examples.brokenlinks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BrokenLinks {
    private WebDriver driver;
    List<Integer> acceptedStatusCodeList = new ArrayList<>();
    Predicate<String> isStatusCodeOk = link -> acceptedStatusCodeList.contains(HTTPConnectionUtil.getResponseCode(link));

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
        driver = new ChromeDriver();
        driver.get("https://www.swtestacademy.com");

        //Filter the status codes
        Collections.addAll(acceptedStatusCodeList, 200, 301, 302, 403);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("");
        driver.quit();
    }

    @Test
    @Order(1)
    public void swTestAcademyHomePageBrokenLinksTest1() {
        long count = driver.findElements(By.tagName("a"))
            .stream()
            .parallel()
            .map(element -> element.getAttribute("href"))
            .filter(Objects::nonNull) ////filter the not null links.
            .filter(link -> !link.isEmpty()) //filter the non-empty links.
            .filter(link -> !link.contains("javascript") && !link.contains("*&")) //Filter other link related patterns.
            .distinct() //remove duplicate links
            .filter(isStatusCodeOk.negate()) //Filter the Not Ok status codes
            .peek(link -> System.out.println("Failed Link: " + link + " Response Code: " + HTTPConnectionUtil.getResponseCode(link)))
            .count();

        System.out.println("Count: " + count);
        Assertions.assertFalse(count > 0);
    }

    @Test
    public void swTestAcademyHomePageBrokenLinksTest2() {
        boolean result = driver.findElements(By.tagName("a"))
            .stream()
            .parallel()
            .map(element -> element.getAttribute("href"))
            .filter(Objects::nonNull) ////filter the not null links.
            .filter(link -> !link.isEmpty()) //filter the non-empty links.
            .filter(link -> !link.contains("javascript") && !link.contains("*&")) //Filter other link related patterns.
            .distinct() //remove duplicate links
            .peek(link -> System.out.println("Link: " + link + " Response Code: " + HTTPConnectionUtil.getResponseCode(link)))
            .anyMatch(isStatusCodeOk.negate());

        Assertions.assertFalse(result);
    }

    @Test
    public void swTestAcademyHomePageBrokenLinksTest3() {
        List<String> brokenLinkList = driver.findElements(By.tagName("a"))
            .stream()
            .parallel()
            .map(element -> element.getAttribute("href"))
            .filter(Objects::nonNull) ////filter the not null links.
            .filter(link -> !link.isEmpty()) //filter the non-empty links.
            .filter(link -> !link.contains("javascript") && !link.contains("*&")) //Filter other link related patterns.
            .distinct() //remove duplicate links
            .filter(isStatusCodeOk.negate())
            .collect(Collectors.toList());

        Assertions.assertFalse(brokenLinkList.size() > 0, brokenLinkList.toString());
    }
}
