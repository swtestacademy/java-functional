package functional.stream.examples;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.SneakyThrows;
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
    List<String>  names   = new ArrayList<>();

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("Test name: " + testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown() {
        System.out.println("");
    }

    private void populateNumbers() {
        Collections.addAll(numbers, 5, 8, 3, 7, 2, 6, 1, 10, 9, 4);
    }

    @SneakyThrows
    private void populateNames() {
        names = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("names.txt").getPath()));
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
        populateNumbers(); //Prepare test data.
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
        numbers.clear(); //Clear test data.
    }

    @Test
    @Order(2)
    public void namesTest() {
        populateNames(); //Prepare test data.

        //Calculate Count of names which are starting with A
        System.out.println("Count of names which are starting with \"A\": " + names.stream()
            .filter(names -> names.startsWith("A"))
            .count());

        //Print the upper-case version for the names which are starting with A.
        names.stream()
            .filter(names -> names.startsWith("A"))
            .map(String::toUpperCase)
            .forEach(System.out::println);

        //Find the longest name and print it.
        names.stream()
            .skip(1)
            .max(Comparator.comparing(String::length))
            .ifPresent(name -> System.out.println("Longest Name length is: " + name.length() + " and the name is: " + name));

        names.clear(); //Clear test data.
    }
}
