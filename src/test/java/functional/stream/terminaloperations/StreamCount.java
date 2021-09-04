package functional.stream.terminaloperations;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamCount {
    List<Integer> numbers = new ArrayList<>();

    @BeforeEach
    public void setup() {
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

    @Test
    public void streamCountTest() {
        long count = numbers.stream()
            .filter(number -> number < 8) //Filter numbers which are smaller than 8.
            .filter(number -> number % 2 == 0) //Filter even numbers.
            .skip(1) //Skip the first filtered number.
            .count(); //Count the rest of the numbers.
        System.out.println("Count: " + count);
    }
}
