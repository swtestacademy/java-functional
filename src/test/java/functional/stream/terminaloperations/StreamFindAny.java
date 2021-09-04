package functional.stream.terminaloperations;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * FindAny use a parallel processing, but FindFirst is using synchronous execution.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamFindAny {
    List<String> texts = new ArrayList<>();

    @BeforeEach
    public void setup() {
        texts.add("Ronaldo");
        texts.add("Messi");
        texts.add("Zlatan");
        texts.add("Pele");
        texts.add("Iniesta");
        texts.add("Zidane");
        texts.add("Ozil");
    }

    @AfterEach
    public void tearDown() {
        texts.clear();
        System.out.println("");
    }

    //Find any of the element which satisfies the condition. Just returns one element from the stream. It does parallel processing.
    @Test
    @Order(1)
    public void findAnyTest() {
        Instant start = Instant.now();
        Optional<String> elementContainsCharZ = texts.stream()
            .map(String::toLowerCase)
            .filter(text -> text.contains("z"))
            .findAny();

        elementContainsCharZ.ifPresent(System.out::println);
        Instant end = Instant.now();
        System.out.println("Elapsed time of findAny: " + Duration.between(start, end).toNanos());
    }

    //Returns the first element. It does synchronous processing.
    @Test
    @Order(2)
    public void findFirstTest() {
        Instant start = Instant.now();
        Optional<String> elementContainsCharZ = texts.stream()
            .map(String::toLowerCase)
            .filter(text -> text.contains("z"))
            .findFirst();

        elementContainsCharZ.ifPresent(System.out::println);
        Instant end = Instant.now();
        System.out.println("Elapsed time of findFirst: " + Duration.between(start, end).toNanos());
    }

    //FindFirst with parallel. Here we have bad performance. Try to do parallel operation when there are
    //some IO operations or long operations. Parallel does not always guarantee the best performance.
    //For broken link tests, parallel improves the performance  a lot because we are hitting the links in parallel.
    @Test
    @Order(3)
    public void findFirstWithParallelTest() {
        Instant start = Instant.now();
        Optional<String> elementContainsCharZ = texts.stream()
            .parallel()
            .map(String::toLowerCase)
            .filter(text -> text.contains("z"))
            .findFirst();

        elementContainsCharZ.ifPresent(System.out::println);
        Instant end = Instant.now();
        System.out.println("Elapsed time of findFirst with Parallel: " + Duration.between(start, end).toNanos());
    }
}
