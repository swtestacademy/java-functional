package functional.stream.examples;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Complex examples for streams.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamPlayGround {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
        numbers.add(5);
        numbers.add(8);
        numbers.add(3);
        numbers.add(7);
        numbers.add(2);
        numbers.add(6);
        numbers.add(1);
        numbers.add(10);
        numbers.add(9);
        numbers.add(4);
    }

    @AfterEach
    public void tearDown() {
        numbers.clear();
        System.out.println("");
    }

    /**
     * In below example we do the followings:
     * 1) We filter odd numbers.
     * 2) We filter numbers bigger than 2.
     * 3) e use peek for debugging.
     * 4) We limit the first 3 element which means only first 3 filtered element will be processed.
     * 5) We sort in Natural (Ascending) order.
     * 6) We use peek for debugging.
     * 7) With map, we transform the number to number*2
     * 8) We skip the first element and process the rest of the elements.
     * 9) With forEach, we display the elements which come to the end of the stream successfully.
     */
    @Test
    @Order(1)
    public void streamPeekFilterLimitSkipMapTest() {
        numbers.stream()
            .filter(number -> number % 2 == 1) //Filter the odd numbers
            .filter(number -> number > 2)
            .peek(number -> System.out.println("Filtered number: " + number)) //Peek is used for debugging purposes.
            .limit(3) //Process first 3 elements.
            .sorted() //By default, sorted works as natural order of Ascending Sort. After sorting, stream pipeline continues.
            .peek(number -> System.out.println("Map operation for number: " + number)) //Peek is used for debugging purposes.
            .map(number -> number * 2) //Transform the number to number*2
            .skip(1) //Skip first 1 elements.
            .forEach(number -> System.out.println("Result of stream: " + number)); //Print the results.
    }
}
