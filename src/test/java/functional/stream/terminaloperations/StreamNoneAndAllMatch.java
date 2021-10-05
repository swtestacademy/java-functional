package functional.stream.terminaloperations;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamNoneAndAllMatch {
    List<String> texts = new ArrayList<>();

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
        texts.add("SW Test Academy!");
        texts.add("Development");
        texts.add("DevOps");
        texts.add("Test Culture");
        texts.add("Real test Examples");
    }

    @Test
    @Order(1)
    public void noneMatchExample() {
        boolean result = texts.stream()
            .filter(text -> !text.isEmpty())
            .map(String::toLowerCase)
            .noneMatch(text -> text.contains("TEST"));

        System.out.println(result);
    }

    @Test
    @Order(2)
    public void allMatchExample() {
        boolean result = texts.stream()
            .filter(text -> !text.isEmpty())
            .map(String::toLowerCase)
            .allMatch(text -> text.contains("TEST"));

        System.out.println(result);
    }
}
