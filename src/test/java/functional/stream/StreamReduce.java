package functional.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * With reduce we can do accumulative operations like sum of all numbers or factorials.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamReduce {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    void setup(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        Collections.addAll(numbers, 1, 2, 3, 4);
    }

    @AfterEach
    void teardown() {
        System.out.println();
    }

    /**
     * Reduce helps us to combine elements into one single object.
     * It is working like an accumulator. Below we calculate sum of numbers.
     */
    @Test
    @Order(1)
    public void streamReduceSumTest() {
        Instant start = Instant.now();
        Optional<Integer> sum = numbers.stream()
            .reduce((a, b) -> a + b);

        sum.ifPresent(result -> System.out.println("Sum is: " + result));
        Instant end = Instant.now();
        System.out.println("Elapsed time of streamReduceSumTest: " + Duration.between(start, end).toNanos());
    }

    @Test
    @Order(1)
    public void streamReduceParallelSumTest() {
        Instant start = Instant.now();
        Optional<Integer> sum = numbers.parallelStream()
            .reduce((a, b) -> a + b);

        sum.ifPresent(result -> System.out.println("Sum is: " + result));
        Instant end = Instant.now();
        System.out.println("Elapsed time of streamReduceParallelSumTest: " + Duration.between(start, end).toNanos());
    }

    @Test
    @Order(3)
    public void intStreamSumTest() {
        Instant start = Instant.now();
        int sum = numbers.stream()
            .mapToInt(number -> number)
            .sum();

        System.out.println("Sum of intStream operation: " + sum);
        Instant end = Instant.now();
        System.out.println("Elapsed time of intStreamSumTest: " + Duration.between(start, end).toNanos());
    }

    @Test
    @Order(4)
    public void streamReduceFactorialTest() {
        Instant start = Instant.now();
        Optional<Integer> sum = numbers.stream()
            .reduce((a, b) -> a * b);

        sum.ifPresent(result -> System.out.println("Factorial is: " + result));
        Instant end = Instant.now();
        System.out.println("Elapsed time of streamReduceFactorialTest: " + Duration.between(start, end).toNanos());
    }
}
