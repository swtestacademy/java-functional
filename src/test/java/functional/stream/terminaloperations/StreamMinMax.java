package functional.stream.terminaloperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamMinMax {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
        Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @AfterEach
    public void tearDown() {
        numbers.clear();
        System.out.println("");
    }

    /**
     * ReverseOrder is DESCENDING order.
     * NaturalOrder is ASCENDING order.
     */
    @Test
    @Order(1)
    public void minTest() {
        Optional<Integer> min = numbers.stream()
            .min(Comparator.naturalOrder());

        min.ifPresent(System.out::println);
    }

    @Test
    @Order(2)
    public void minReverseWayTest() {
        Optional<Integer> min = numbers.stream()
            .min(Comparator.reverseOrder());

        min.ifPresent(System.out::println);
    }

    @Test
    @Order(3)
    public void maxTest() {
        Optional<Integer> max = numbers.stream()
            .max(Comparator.naturalOrder());

        max.ifPresent(System.out::println);
    }

    @Test
    @Order(4)
    public void maxReverseWayTest() {
        Optional<Integer> max = numbers.stream()
            .max(Comparator.reverseOrder());

        max.ifPresent(System.out::println);
    }
}
