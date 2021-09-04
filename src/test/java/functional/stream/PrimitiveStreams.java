package functional.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PrimitiveStreams {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    void setup() {
        Collections.addAll(numbers, 1, 2, 3, 4);
    }

    /**
     * In below example we did several primitive type conversions.
     * We have Stream<Integer> then we converted it to LongStream, then DoubleStream, then IntStream.
     * Because of this conversions, sum performance is not good. (Check times in StreamReduce class examples.)
     */
    @Test
    @Order(1)
    public void primitiveStreamConversionTest() {
        Instant start = Instant.now();
        int sum = numbers.stream()
            .mapToLong(a -> a)
            .mapToDouble(a -> (double) a)
            .mapToInt(a -> (int) a)
            .sum();

        System.out.println("Sum of primitiveStreamConversionTest operation: " + sum);
        Instant end = Instant.now();
        System.out.println("Elapsed time of primitiveStreamConversionTest: " + Duration.between(start, end).toNanos());
    }

    @Test
    @Order(1)
    public void intStreamRangeTest() {
        Instant start = Instant.now();
        int sum = IntStream.range(1, 4)
            .sum();

        System.out.println("Sum of intStreamRangeTest operation: " + sum);
        Instant end = Instant.now();
        System.out.println("Elapsed time of intStreamRangeTest: " + Duration.between(start, end).toNanos());
    }

    @Test
    @Order(1)
    public void intStreamRangeClosedTest() {
        Instant start = Instant.now();
        int sum = IntStream.rangeClosed(1, 4)
            .sum();

        System.out.println("Sum of intStreamRangeClosedTest operation: " + sum);
        Instant end = Instant.now();
        System.out.println("Elapsed time of intStreamRangeClosedTest: " + Duration.between(start, end).toNanos());
    }
}
