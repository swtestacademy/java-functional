package functional.stream.terminaloperations;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamAnyMatch {
    List<String> texts = new ArrayList<>();

    @BeforeEach
    public void setup() {
        texts.add("SW Test Academy!");
        texts.add("Development");
        texts.add("DevOps");
        texts.add("Test Culture");
        texts.add("Real test Examples");
    }

    @Test
    public void anyMatchExample() {
        boolean result = texts.stream()
            .filter(text -> !text.isEmpty())
            .map(String::toLowerCase)
            .anyMatch(text -> text.contains("test"));

        System.out.println(result);
    }
}
