package functional.stream.terminaloperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamMinMax {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    public void setup() {
        //Another method: Collections.addAll(numbers, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
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
    public void minTest() {
        Optional<Integer> min = numbers.stream()
            .min(Comparator.naturalOrder());

        min.ifPresent(System.out::println);
    }

    @Test
    public void minReverseWayTest() {
        Optional<Integer> min = numbers.stream()
            .max(Comparator.reverseOrder());

        min.ifPresent(System.out::println);
    }

    @Test
    public void maxTest() {
        Optional<Integer> min = numbers.stream()
            .max(Comparator.naturalOrder());

        min.ifPresent(System.out::println);
    }

    @Test
    public void maxReverseWayTest() {
        Optional<Integer> min = numbers.stream()
            .min(Comparator.reverseOrder());

        min.ifPresent(System.out::println);
    }
}
