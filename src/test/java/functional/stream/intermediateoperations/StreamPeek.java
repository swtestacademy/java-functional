package functional.stream.intermediateoperations;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Peek is using debugging purposes.
 */
public class StreamPeek {
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
    }

    @Test
    public void streamPeekTest() {
        System.out.println("Stream operations are starting!");
        numbers.stream()
            .peek(number -> System.out.println("Filter operation for number: " + number)) //Peek is used for debugging purposes.
            .filter(number -> number % 2 == 1) //Filter the odd numbers
            .limit(4) //After 4th element stop the stream. Process first 4 element.
            .peek(number -> System.out.println("Map operation for number: " + number)) //Peek is used for debugging purposes.
            .map(number -> number * 2) //Transform the number to number*2
            .forEach(number -> System.out.println("Result of stream: " + number)); //Print the results.
        System.out.println("Stream operations finished!");
    }
}
