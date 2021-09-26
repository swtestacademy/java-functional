package functional.stream.intermediateoperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Distinct removes the repeated elements in the stream.
 */
public class StreamDistinct {

    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    public void setup() {
       Collections.addAll(numbers, 1, 2, 3, 4, 4, 4, 5, 5, 5, 5);
    }

    @AfterEach
    public void tearDown() {
        numbers.clear();
    }

    @Test
    public void streamDistinctTest() {
        System.out.println("Stream operations are starting!");

        numbers.stream()
            .distinct()
            .forEach(number -> System.out.println("Result of stream: " + number)); //Print the results.

        System.out.println("Stream operations finished!");
    }
}
