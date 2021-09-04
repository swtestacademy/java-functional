package functional.stream.intermediateoperations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Sorted gets all the data and process it then stream pipeline continues.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreamSorted {
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
     * Below the stream first limits 4 filtered elements and then sorts them and then stream pipeline works.
     */
    @Test
    @Order(1)
    public void streamSortedTest() {
        numbers.stream()
            .peek(number -> System.out.println("Filter operation for number: " + number)) //Peek is used for debugging purposes.
            .filter(number -> number % 2 == 1) //Filter the odd numbers
            .limit(4) //After 4th element stop the stream. Process first 4 element.
            .sorted() //By default, sorted works as natural order of Ascending Sort. After sorting, stream pipeline continues.
            .peek(number -> System.out.println("Map operation for number: " + number)) //Peek is used for debugging purposes.
            .map(number -> number * 2) //Transform the number to number*2
            .forEach(number -> System.out.println("Result of stream: " + number)); //Print the results.
    }

    /**
     * Natural sort is Ascending Sort
     */
    @Test
    @Order(2)
    public void streamNaturalOrderSortTest() {
        numbers.stream()
            .peek(number -> System.out.println("Filter operation for number: " + number)) //Peek is used for debugging purposes.
            .filter(number -> number % 2 == 1) //Filter the odd numbers
            .sorted(Comparator.naturalOrder()) //Natural order of sorting. (Ascending Sort)
            .limit(4) //After 4th element stop the stream. Process first 4 element.
            .peek(number -> System.out.println("Map operation for number: " + number)) //Peek is used for debugging purposes.
            .map(number -> number * 2) //Transform the number to number*2
            .forEach(number -> System.out.println("Result of stream: " + number)); //Print the results.
    }

    /**
     * Reverse sort is Descending Sort
     */
    @Test
    @Order(3)
    public void streamReverseOrderSortTest() {
        numbers.stream()
            .peek(number -> System.out.println("Filter operation for number: " + number)) //Peek is used for debugging purposes.
            .filter(number -> number % 2 == 1) //Filter the odd numbers
            .sorted(Comparator.reverseOrder()) //Reverse order of sorting. (Descending Sort)
            .limit(4) //After 4th element stop the stream. Process first 4 element.
            .peek(number -> System.out.println("Map operation for number: " + number)) //Peek is used for debugging purposes.
            .map(number -> number * 2) //Transform the number to number*2
            .forEach(number -> System.out.println("Result of stream: " + number)); //Print the results.
    }
}
